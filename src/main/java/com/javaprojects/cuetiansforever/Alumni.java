package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class Alumni implements Initializable {
    private Stage stage;
    private Scene scene;
    Home data;
    @FXML
    private Label alumniname;
    public void logout(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("home"));
        stage.setScene(scene);
        stage.show();

    }
    public void Updatescene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Update(Alumni)"));
        stage.setScene(scene);
        stage.show();
    }
    public void switchtojob(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("JobBoard"));
        stage.setScene(scene);
        stage.show();
    }
    public void Reportscene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Report"));
        stage.setScene(scene);
        stage.show();
    }
    public void switchtojobscene(ActionEvent event)throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("PostJob"));
        stage.setScene(scene);
        stage.show();
    }
    public void switchtodashboard(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Dashboard"));
        stage.setScene(scene);
        stage.show();
    }
    public void viewmyjobs(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("AlumniPostedJobs"));
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alumniname.setText(db.cuetian.getFirstName()+" "+db.cuetian.getLastName());
    }
}
