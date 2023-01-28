package com.javaprojects.cuetiansforever;

import Backend.JavadbContactno;
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
import org.controlsfx.control.action.Action;

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
    //private ArrayList<JavadbCuetian> temp;
    private void splitnames(String name){
        String[] splitstring  = name.split(" ");
        firstName = splitstring[0];
        lastName = splitstring[1];
        System.out.println(firstName);
        System.out.println(lastName);
    }
    private boolean checknameinput(){
        if(name.getText().isEmpty()){
            System.out.println("blank name");
            return false;
        }
        System.out.println("1here");
        return true;
    }
    private boolean checkbatchinput(){
        if(batch.getText().isEmpty()){
            System.out.println("blank batch");
            return false;
        }
        System.out.println("2here");
        return true;
    }
    private boolean checkcompanyinput(){
        if(company.getText().isEmpty()){
            System.out.println("blank company");
            return false;
        }
        System.out.println("3here");
        return true;
    }
    // derived attribute first+name %?%
    private ArrayList<JavadbCuetian> getsearchresultbyname(String name){
        splitnames(name);
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbyname(firstName, lastName);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbybatch(long batch){
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbybatch(batch);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbycompany(String company){
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbycompany(company);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbynameandbatch(String name, long batch){
        splitnames(name);
        ArrayList<JavadbCuetian> list;
        list =  JavadbCuetian.getlistbynameandbatch(firstName, lastName, batch);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbynameandcompany(String name, String company){
        splitnames(name);
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbynameandcompany(firstName, lastName, company);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbybatchandcompany(long batch, String company){
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbybatchandcompany(batch, company);
        return list;
    }
    private ArrayList<JavadbCuetian> getsearchresultbyall(String name, long batch, String company){
        splitnames(name);
        ArrayList<JavadbCuetian> list;
        list = JavadbCuetian.getlistbyall(firstName, lastName, batch, company);
        return list;
    }

    @FXML
    public void searchresultshow(ActionEvent event) throws IOException{
        System.out.println("Passed");
        ArrayList<JavadbCuetian> tmp = new ArrayList<JavadbCuetian>();
        if(checknameinput()==true && checkbatchinput()==false && checkcompanyinput()==false){
            tmp = getsearchresultbyname(name.getText());
        }
        if(checknameinput()==false && checkbatchinput()==true && checkcompanyinput()==false){
            tmp  = getsearchresultbybatch(Long.parseLong(batch.getText()));
        }
        if(checknameinput()==false && checkbatchinput()==false && checkcompanyinput()==true){
            tmp  = getsearchresultbycompany(company.getText());
        }
        if(checknameinput()==true && checkbatchinput()==true && checkcompanyinput()==false){
            tmp  = getsearchresultbynameandbatch(name.getText(), Long.parseLong(batch.getText()));
        }
        if(checknameinput()==true && checkbatchinput()==false && checkcompanyinput()==true){
            tmp  = getsearchresultbynameandcompany(name.getText(), company.getText());
        }
        if(checknameinput()==false && checkbatchinput()==true && checkcompanyinput()==true){
            tmp  = getsearchresultbybatchandcompany(Long.parseLong(batch.getText()), company.getText());
        }
        if(checknameinput()==true && checkbatchinput()==true && checkcompanyinput()==true){
            tmp  = getsearchresultbyall(name.getText(), Long.parseLong(batch.getText()), company.getText());
        }
        showallprofiles(tmp);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<JavadbCuetian> list = JavadbCuetian.getall();
        showallprofiles(list);

    }
    void showallprofiles(ArrayList<JavadbCuetian> list) {
        remove_all_product();
        Node[] nodes = new Node[list.size()];
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
    void remove_all_product(){
        ArrayList<Node> removal_list = new ArrayList<Node>();
        for (int i = 0; i < profileholder.getChildren().size(); i++) {
            removal_list.add(profileholder.getChildren().get(i));
            // if (scrollPnItems.getChildren().get(i).getId() == "item_box") {
            //     System.out.println(scrollPnItems.getChildren().get(i).getId());
            // }
        }
        profileholder.getChildren().removeAll(removal_list);
        // System.out.println(scrollPnItems.getChildren().removeAll(removal_list)?"Removed all product":"Failed");
    }
}
