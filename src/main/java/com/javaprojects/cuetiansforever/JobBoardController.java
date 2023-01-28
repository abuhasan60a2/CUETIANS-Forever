package com.javaprojects.cuetiansforever;
import Backend.JavadbJob;
import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class JobBoardController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private VBox jobholder= null;
    private int totaljobavailable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ArrayList<JavadbJob> list = JavadbJob.getAllJobs();
       showalljobs(list);

    }
    void showalljobs(ArrayList<JavadbJob> list) {
        Node[] nodes = new Node[JavadbJob.countJobs()];
        for(int i =0; i< nodes.length; i++){
            try {
                final int j = i;
                ResourceBundle r = new ResourceBundle() {
                    @Override
                    protected Object handleGetObject(String key) {
                        if(key == "id"){
                            System.out.println(list.get(j).getId());
                            return list.get(j).getId();
                        }
                        if (key == "jobtitle") {
                            return list.get(j).getJobTitle();
                        }
                        if (key == "jobdescription") {
                            return list.get(j).getJobDescription();
                        }
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }

                    @Override
                    public Enumeration<String> getKeys() {
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }
                };
                nodes[i] = FXMLLoader.load(getClass().getResource("Job-Row.fxml"), r);
                jobholder.getChildren().add(nodes[i]);
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
