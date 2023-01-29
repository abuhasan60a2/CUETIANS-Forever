package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class UpdateStudent {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField repassword;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextArea presentaddress;
    @FXML
    private TextArea permanentaddress;
    @FXML
    private TextField facebookprofile;
    @FXML
    private TextField linkedinprofile;

    public void backtohome(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Student"));
        stage.setScene(scene);
        stage.show();
    }
}
