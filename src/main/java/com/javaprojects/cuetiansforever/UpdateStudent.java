package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class UpdateStudent {
    private Stage stage;
    private Scene scene;
    public void backtohome(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Student"));
        stage.setScene(scene);
        stage.show();
    }
}
