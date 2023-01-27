package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class UpdateAlumni implements Initializable {
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
    private TextField profession;
    @FXML
    private TextField company;
    @FXML
    private TextField facebookprofile;
    @FXML
    private TextField linkedinprofile;

    public void backtohome(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Alumni"));
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            firstname.setText(db.cuetian.getFirstName());
            lastname.setText(db.cuetian.getLastName());
            email.setText(db.cuetian.getEmail());
            phonenumber.setText(String.valueOf(db.cuetian.getPhoneNumber()));
            presentaddress.setText(db.cuetian.getPresentAddress());
            permanentaddress.setText(db.cuetian.getPermanentAddress());
            profession.setText(db.cuetian.getProfession());
            company.setText(db.cuetian.getCompany());
            facebookprofile.setText(db.cuetian.getFacebookProfile());
            linkedinprofile.setText(db.cuetian.getLinkedInProfile());


    }
}
