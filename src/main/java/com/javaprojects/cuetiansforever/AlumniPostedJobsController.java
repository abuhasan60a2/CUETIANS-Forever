package com.javaprojects.cuetiansforever;
import Backend.db;
import Backend.JavadbJob;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class AlumniPostedJobsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private long studentid = db.cuetian.getStudentId();
    @FXML
    private VBox jobholder = null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<JavadbJob> list = JavadbJob.getlistbyid(studentid);
        showalljobs(list,studentid);
    }
    private void showalljobs(ArrayList<JavadbJob> list,long studentid){
        Node[] nodes = new Node[JavadbJob.countjobsbyid(studentid)];
        for(int i =0; i< nodes.length; i++){
            try {
                final int j = i;
                ResourceBundle r = new ResourceBundle() {
                    @Override
                    protected Object handleGetObject(String key) {
                        if(key == "id"){
                            System.out.println(list.get(j).getId());
                            return String.valueOf( list.get(j).getId());
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
                nodes[i] = FXMLLoader.load(getClass().getResource("AlumniPostedJob-Row.fxml"), r);
                jobholder.getChildren().add(nodes[i]);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void backtohome(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Alumni"));
        stage.setScene(scene);
        stage.show();
    }
}
