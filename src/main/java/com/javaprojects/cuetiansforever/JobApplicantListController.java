package com.javaprojects.cuetiansforever;

import Backend.JavadbCuetian;
import Backend.JavadbJob;
import Backend.JavadbJobCuetianSeek;
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

public class JobApplicantListController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private VBox applicantholder = null;
    private int totaljobavailable;
    private long job_id;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        job_id = Long.parseLong(resourceBundle.getString("id"));
        System.out.println(job_id);
        ArrayList<JavadbJobCuetianSeek> list = JavadbJobCuetianSeek.getalpplicantsdata(job_id);
        show_all_applicants(list);

    }
    void show_all_applicants(ArrayList<JavadbJobCuetianSeek> list) {
        Node[] nodes = new Node[JavadbJobCuetianSeek.countapplicants(job_id)];
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
                        if (key == "JobID") {
                            return String.valueOf(list.get(j).getJobId());
                        }
                        if (key == "CuetianID") {
                            return String.valueOf(list.get(j).getCuetianId());
                        }
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }

                    @Override
                    public Enumeration<String> getKeys() {
                        throw new UnsupportedOperationException("Not enumeration supported yet.");
                    }
                };
                nodes[i] = FXMLLoader.load(getClass().getResource("JobApplicantRow.fxml"), r);
                applicantholder.getChildren().add(nodes[i]);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void return_on_button_click(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("AlumniPostedJobs"));
        stage.setScene(scene);
        stage.show();
    }
}
