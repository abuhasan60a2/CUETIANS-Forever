package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.Event;


import java.io.IOException;
import com.javaprojects.cuetiansforever.HelloApplication;
public class Home {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void changetoreg(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
