package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JobApplicantRowController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label studentid;
    @FXML
    private Label name;
    @FXML
    private Label batch;
    private long student_id;
    private String username;
    private long Batch;
    private ResourceBundle saved_resource;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        student_id = Long.parseLong(resourceBundle.getString("CuetianID"));
        Connection source = db.makeConnections();
        try {
            PreparedStatement st = source.prepareStatement("SELECT * FROM javadb_cuetian WHERE student_id = ?");
            st.setLong(1,student_id);
            ResultSet rs  = st.executeQuery();
            rs.next();
            username = rs.getString("first_name")+" "+rs.getString("last_name");
            Batch = rs.getLong("batch");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentid.setText(String.valueOf(student_id));
        name.setText(username);
        batch.setText(String.valueOf(Batch));
        this.saved_resource = resourceBundle;

    }
    public void showdetails(ActionEvent event) {
        try {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(HelloApplication.loadFXMLwithresource("JobApplicantDashBoard",this.saved_resource));
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
