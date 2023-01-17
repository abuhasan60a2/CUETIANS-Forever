package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void studentreg(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register-2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void alumnireg(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register-1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
