package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class Alumni {
    private Stage stage;
    private Scene scene;
    Home data;
    @FXML
    Label alumniname;
    public void logout(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("home"));
        stage.setScene(scene);
        stage.show();

    }
    public void Updatescene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Update"));
        stage.setScene(scene);
        stage.show();
    }
    public void Reportscene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Report"));
        stage.setScene(scene);
        stage.show();
    }
}
