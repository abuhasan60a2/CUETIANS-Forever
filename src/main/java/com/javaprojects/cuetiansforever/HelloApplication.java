package com.javaprojects.cuetiansforever;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
         scene = new Scene(loadFXML("home"));
        stage.setScene(scene);
        stage.show();
    }
    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

//    static void setRootwithresource(String fxml,ResourceBundle state) throws IOException {
//
//        scene.setRoot(loadFXMLwithresource( fxml,state));
//
//    }
    static Parent loadFXMLwithresource(String fxml, ResourceBundle state) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"),state);
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
}