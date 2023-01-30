package com.javaprojects.cuetiansforever;

import Backend.JavadbCuetian;
import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class UpdateAlumni implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane root_panel;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repassword;
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
    @FXML
    private Label first_name;
    @FXML
    private Label last_name;
    @FXML
    private Label Email;
    @FXML
    private Label Password;
    @FXML
    private Label confirm_password;
    @FXML
    private Label phone_number;
    @FXML
    private Label present_address;
    @FXML
    private Label permanent_address;
    @FXML
    private Label Profession;
    @FXML
    private Label Company;
    @FXML
    private Label facebook_profile;
    @FXML
    private Label linkedin_profile;
    String dbfirstname;
    String dblastname;
    String dbemail;
    String finalpassword;
    long dbphonenumber=-1;
    String dbpresentaddress;
    String dbpermanentaddress;
    String dbprofession;
    String dbcompany;
    String dbfacebookprofile;
    String dblinkedinprofile;
    private boolean checkfirstnamefield(){
        if(firstname.getText().isEmpty()==true){
            return false;
        }
        dbfirstname = firstname.getText();
        return true;

    }
    private boolean checklastnamefield(){
        if(lastname.getText().isEmpty()==true){
            return false;
        }
        dblastname = lastname.getText();
        return true;

    }
    private boolean checkpasswordfield(){
        if(password.getText().isEmpty()==true){
            return false;
            //Password.setText("This is a Required Field");
        }
        finalpassword = password.getText();
        return true;
    }
    private boolean checkrepasswordfield(){
        if(repassword.getText().isEmpty()==true){
            return false;
        }
        return true;
    }
//    private boolean validatepassword(){
//        if(password.getText().equals(repassword.getText())==true){
//            finalpassword = password.getText();
//            return true;
//        }
//        return false;
//    }
    private boolean checkemailfield(){
        if(email.getText().isEmpty()==true){
            return false;
        }
        dbemail = email.getText();
        return true;
    }
   private boolean checkpresentaddress(){
        if(presentaddress.getText().isEmpty()==true){
            return false;
        }
        dbpresentaddress = presentaddress.getText();
        return true;
   }
   private boolean checkpermanentaddress(){
        if(permanentaddress.getText().isEmpty()==true) {
            return false;
        }
        dbpermanentaddress = permanentaddress.getText();
        return true;
   }
   public void checkphonenumber(){
        if(phonenumber.getText().isEmpty()==true){
            return;
        }
        dbphonenumber = Long.parseLong(phonenumber.getText());
   }
   private boolean checkProfession(){
        if(profession.getText().isEmpty()==true){
                return false;
        }
        dbprofession = profession.getText();
        return true;
   }
   private boolean checkCompany(){
        if(company.getText().isEmpty()==true){
            return false;
        }
        dbcompany = company.getText();
        return true;
   }
   public void setFacebookprofile(){
        dbfacebookprofile = facebookprofile.getText();
   }
   public void setLinkedinprofile(){
        dblinkedinprofile = linkedinprofile.getText();
   }
   public void update_profile_onClick(ActionEvent event)throws IOException{
        boolean blank = false;
        if(checkfirstnamefield()==false ){
            blank = true;
            first_name.setText("this is a required filed");

        }
        if(checklastnamefield()==false){
            blank = true;
            last_name.setText("this is a required field");
        }
        if(checkemailfield()==false){
            blank = true;
            Email.setText("This is a required field");
        }
        if(checkpasswordfield()==false){
            blank = true;
            Password.setText("This is a required field");
        }
        if(password.getText().equals(repassword.getText())==false) {
            blank = true;
            confirm_password.setText("Passwords do not match");
        }
        else{
            finalpassword=password.getText();
        }
        if(checkpresentaddress()==false){
            blank = true;
            present_address.setText("This is a required field");
        }
        if(checkpermanentaddress()==false){
            blank = true;
            permanent_address.setText("This is a required field");
        }
        if(checkProfession()==false){
            blank = true;
            Profession.setText("This is a required field");
        }
        if(checkCompany()==false){
            blank = true;
            Company.setText("This is a required field");
        }
        if(blank == true){
            return;
        }
        checkphonenumber();
        setFacebookprofile();
        setLinkedinprofile();
       try {
           Connection source = db.makeConnections();
           PreparedStatement st = source.prepareStatement("UPDATE javadb_cuetian SET first_name = ?, last_name = ?, email = ?, password = ?, phone_number = ?,  present_address = ?, permanent_address = ?, profession = ?, Company = ?, facebook_profile = ?, linkedIn_profile = ? WHERE javadb_cuetian.student_id = ?");
           st.setString(1, dbfirstname);
           st.setString(2, dblastname);
           st.setString(3, dbemail);
           st.setString(4,finalpassword);
           if(dbphonenumber==-1){
               st.setNull(5, Types.NULL);
           }
           else{
               st.setLong(5,dbphonenumber);
           }
           //st.setLong(5,dbphonenumber);
           st.setString(6,dbpresentaddress);
           st.setString(7,dbpermanentaddress);
           st.setString(8,dbprofession);
           st.setString(9,dbcompany);
           if(dbfacebookprofile.isEmpty()==true){
               st.setNull(10, Types.NULL);
           }
           else{
               st.setString(10,dbfacebookprofile);
           }
           if(dblinkedinprofile.isEmpty()==true){
               st.setNull(11,Types.VARCHAR);
           }
           else{
               st.setString(11,dblinkedinprofile);
           }
           st.setLong(12,db.cuetian.getStudentId());
           st.executeUpdate();
           st.close();
           db.cuetian= JavadbCuetian.login(db.cuetian.getStudentId(),password.getText());
           backtohome(event);

       } catch (SQLException e) {
           e.printStackTrace();
       }

   }
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
            String s = Long.toString(db.cuetian.getPhoneNumber());
            System.out.println(s);
            phonenumber.setText(s);
            presentaddress.setText(db.cuetian.getPresentAddress());
            permanentaddress.setText(db.cuetian.getPermanentAddress());
            profession.setText(db.cuetian.getProfession());
            company.setText(db.cuetian.getCompany());
            facebookprofile.setText(db.cuetian.getFacebookProfile());
            linkedinprofile.setText(db.cuetian.getLinkedInProfile());


    }
}
//        AtomicBoolean is_something_empty= new AtomicBoolean(false);
//        root_panel.getChildren().forEach(node->{
//            System.out.println(node.getId());
//            if(node instanceof TextField){
//
//                if(!(Objects.equals(((TextField) node).getId(), "phonenumber") || Objects.equals(((TextField) node).getId(), "facebookprofile") || Objects.equals(((TextField) node).getId(), "linkedinprofile"))){
//                    if(((TextField)node).getText().isEmpty()){
//                        is_something_empty.set(true);
//                        ((TextField)node).setStyle("-fx-border-color:#ff0000");
//                        ((TextField)node).setStyle("-fx-border-width:1");
//                    }
//                }
//            }else if(node instanceof PasswordField){
//                if(((PasswordField)node).getText().isEmpty()) {
//                    is_something_empty.set(true);
//                    ((PasswordField)node).setStyle("-fx-border-color:#ff0000");
//                    ((PasswordField)node).setStyle("-fx-border-width:1");
//                }
//
//
//            }else if(node instanceof TextArea){
//                if(((TextArea)node).getText().isEmpty()) {
//                    is_something_empty.set(true);
//                    ((TextArea)node).setStyle("-fx-border-color:#ff0000");
//                    ((TextArea)node).setStyle("-fx-border-width:1");
//                }
//            }
//        });
//
//    if(is_something_empty.get()){
//        root_panel.applyCss();
//        return;
//    }