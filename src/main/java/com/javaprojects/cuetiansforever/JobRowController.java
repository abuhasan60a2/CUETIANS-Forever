package com.javaprojects.cuetiansforever;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class JobRowController implements Initializable {
    @FXML
    private Label jobtitle;
    @FXML
    private Label jobdescription;
    @FXML
    private Button viewjobdashboard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jobtitle.setText(resourceBundle.getString("jobtitle"));
        jobdescription.setText(resourceBundle.getString("jobdescription"));
    }
}
