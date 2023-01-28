package com.javaprojects.cuetiansforever;

import Backend.JavadbJob;
import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import Backend.JavadbCuetian;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class ProfileSearchController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField name;
    @FXML
    private TextField batch;
    @FXML
    private TextField company;
    @FXML
    private VBox profileholder;
    private String firstName;
    private String lastName;
    private long userbatch;
    private String usercompany;
    private ArrayList<JavadbCuetian> temp;
    private void splitnames(String name){
        String[] splitstring  = name.split(" ");
        firstName = splitstring[0];
        lastName = splitstring[1];
        System.out.println(firstName);
        System.out.println(lastName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<JavadbCuetian> list = JavadbCuetian.getall();
        showallprofiles(list);

    }
    void showallprofiles(ArrayList<JavadbCuetian> list) {
        Node[] nodes = new Node[JavadbCuetian.countall()];
        for(int i =0; i< nodes.length; i++){
            try {
                final int j = i;
                ResourceBundle r = new ResourceBundle() {
                    @Override
                    protected Object handleGetObject(String key) {
                        if (key == "studentid") {
                            return String.valueOf(list.get(j).getStudentId());
                        }
                        if (key == "name") {
                            return list.get(j).getFirstName()+" "+list.get(j).getLastName();
                        }
                        if(key=="batch"){
                            return String.valueOf(list.get(j).getBatch());
                        }
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }

                    @Override
                    public Enumeration<String> getKeys() {
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }
                };
                nodes[i] = FXMLLoader.load(getClass().getResource("ProfileSearchRow.fxml"), r);
                profileholder.getChildren().add(nodes[i]);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void backtohome(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String studentsatus = db.cuetian.getStudentStatus();
        if(studentsatus.equals("A")) {
            scene = new Scene(loadFXML("Alumni"));
        }
        else {
            scene = new Scene(loadFXML("Student"));
        }
        stage.setScene(scene);
        stage.show();
    }
}
