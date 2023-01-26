package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import Backend.db;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class StuReg {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField studentid;
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
    private TextField dateofbirth;
    @FXML
    private TextField age;
    @FXML
    private TextArea presentaddress;
    @FXML
    private TextArea permanentaddress;
    @FXML
    private TextField department;
    @FXML
    private TextField batch;
    @FXML
    private TextField joiningyear;
    @FXML
    private TextField facebookprofile;
    @FXML
    private TextField linkedinprofile;
    @FXML
    private Label passworderror;
    @FXML
    private Label errortext;
    private long Studentid;
    private String firstName;
    private String lastName;
    private String Email;
    private String Password;
    private String confirmpassword;
    private long PhoneNumber;
    private String dob;
    private long Age;
    private String PresentAddress;
    private String PermanentAddress;
    private String Department;
    private long Batch;
    private String JoiningYear;
    private String facebook;
    private String linkedin;
    public String validatepassword(String Password, String confirmpassword) {
        if (Password.equals(confirmpassword)) {
            return Password;
        }
        return "";
    }

    private boolean formerror() {
        return studentid.getText() == "" | firstname.getText() == "" | lastname.getText() == "" | email.getText() == "" | password.getText() == "" |
                repassword.getText() == "" | phonenumber.getText() == "" | dateofbirth.getText() == "" | age.getText() == ""
                | presentaddress.getText() == "" | permanentaddress.getText() == "" | department.getText() == "" | batch.getText() == ""
                | joiningyear.getText() == "" | facebookprofile.getText() == "" | linkedinprofile.getText() == "";

    }
    private boolean signupcheck() throws SQLException {
        Studentid = Long.parseLong(studentid.getText());
        firstName = firstname.getText();
        lastName = lastname.getText();
        Email = email.getText();
        Password = validatepassword(password.getText(), repassword.getText());
        PhoneNumber = Long.parseLong(phonenumber.getText());
        dob = dateofbirth.getText();
        Age = Long.parseLong(age.getText());
        PresentAddress = presentaddress.getText();
        PermanentAddress = permanentaddress.getText();
        Department = department.getText();
        Batch = Long.parseLong(batch.getText());
        JoiningYear = joiningyear.getText();
        facebook = facebookprofile.getText();
        linkedin = linkedinprofile.getText();
        if(Password.equals("")){
            System.out.println("no password");
            passworderror.setText("Didnt match password");
            return false;
        }
        if (formerror() == true) {
            System.out.println("blank field here");
            errortext.setText("Please fillup the field");
            return false;
        }
        if(db.signup(Studentid, firstName, lastName, Email, Password, PhoneNumber, Department, "S", Batch, dob, Age, PresentAddress, PermanentAddress, JoiningYear, null, "student", "cuet", facebook, linkedin)==true) {
            return true;
        }
        System.out.println("some error here");
            return false;
    }
    public void register(ActionEvent event) throws SQLException, IOException {
       if(signupcheck()==true) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(loadFXML("Student"));
            stage.setScene(scene);
            stage.show();

        } else {
            errortext.setText("sorry there was some error");
        }

    }

    public void backtohome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
