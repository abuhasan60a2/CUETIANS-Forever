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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class SearchRowDashboardController implements Initializable {
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
    private long studentid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentid = Long.parseLong(resourceBundle.getString("studentid"));
        System.out.println(studentid);
        try {
            Connection source  = db.makeConnections();

            PreparedStatement st = source.prepareStatement("SELECT * FROM javadb_cuetian WHERE student_id=?");
            st.setLong(1, studentid);
            ResultSet rs = st.executeQuery();
            rs.next();
            System.out.println(rs.getString("first_name"));
            name.setText(rs.getString("first_name")+" "+rs.getString("last_name"));
            email.setText(rs.getString("email"));
            presentaddress.setText(rs.getString("present_address"));
            permanentaddress.setText(rs.getString("permanent_address"));
            facebook.setText(rs.getString("facebook_profile"));
            linkedin.setText(rs.getString("linkedin_profile"));
            department.setText(rs.getString("department"));
            batch.setText(String.valueOf(rs.getLong("batch")));
            profession.setText(rs.getString("profession"));
            company.setText(rs.getString("company"));
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
    public void returntosearch(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("ProfileSearch"));
        stage.setScene(scene);
        stage.show();
    }


}
