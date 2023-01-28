package com.javaprojects.cuetiansforever;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileSearchRowController implements Initializable {
    @FXML
    private Label studentid;
    @FXML
    private Label name;
    @FXML
    private Label batch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentid.setText(resourceBundle.getString("studentid"));
        name.setText(resourceBundle.getString("name"));
        batch.setText(resourceBundle.getString("batch"));
    }
}
