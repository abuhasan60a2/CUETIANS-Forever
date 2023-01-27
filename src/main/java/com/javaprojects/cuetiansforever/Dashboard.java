package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import Backend.db;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class Dashboard implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Label name;
    @FXML
    private Label email;
    @FXML
    private Label presentaddress;
    @FXML
    private Label permanentaddress;
    @FXML
    private Label facebook;
    @FXML
    private Label linkedin;
    @FXML
    private Label department;
    @FXML
    private Label batch;
    @FXML
    private Label profession;
    @FXML
    private Label company;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(db.cuetian.getFirstName()+" "+db.cuetian.getLastName());
        email.setText(db.cuetian.getEmail());
        presentaddress.setText(db.cuetian.getPresentAddress());
        permanentaddress.setText(db.cuetian.getPermanentAddress());
        facebook.setText(db.cuetian.getFacebookProfile());
        linkedin.setText(db.cuetian.getLinkedInProfile());
        department.setText(db.cuetian.getDepartment());
        batch.setText(String.valueOf(db.cuetian.getBatch()));
        profession.setText(db.cuetian.getProfession());
        company.setText(db.cuetian.getCompany());
    }
    public void returntohome(ActionEvent event) throws IOException {
        String student_status  = db.cuetian.getStudentStatus();
        System.out.println(student_status);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(student_status.equals("A")){
            scene = new Scene(loadFXML("Alumni"));
        }
        else{
            scene = new Scene(loadFXML("Student"));
        }
        stage.setScene(scene);
        stage.show();
    }
}
