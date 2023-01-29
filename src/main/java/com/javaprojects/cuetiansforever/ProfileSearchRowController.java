package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;


public class ProfileSearchRowController implements Initializable {
    private  Stage stage;
    private Scene scene;
    @FXML
    private Label studentid;
    @FXML
    private Label name;
    @FXML
    private Label batch;
    private ResourceBundle saved_resource;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentid.setText(resourceBundle.getString("studentid"));
        name.setText(resourceBundle.getString("name"));
        batch.setText(resourceBundle.getString("batch"));
        saved_resource = resourceBundle;
    }

    public void showdetails(ActionEvent event) {
        try {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(HelloApplication.loadFXMLwithresource("SearchRowDashboard",this.saved_resource));
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
