package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class JobRowController implements Initializable {
    private  Stage stage;
    private Scene scene;
    @FXML
    private Label jobtitle;
    @FXML
    private Label jobdescription;
    @FXML
    private Button viewjobdashboard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(resourceBundle.getString("jobtitle"));
        jobtitle.setText(resourceBundle.getString("jobtitle"));
        jobdescription.setText(resourceBundle.getString("jobdescription"));
    }
    public void showdetails(ActionEvent event) throws Exception {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Job-Details"));
        stage.setScene(scene);
        stage.show();
    }
}
