package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;
import com.javaprojects.cuetiansforever.Home;
public class Student {
    private  Stage stage;
    private Scene scene;

    @FXML
    Label studentname;
    public void logout(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("home"));
        stage.setScene(scene);
        stage.show();

    }
    public void getname(ActionEvent event){
        Home data = new Home();
        System.out.println(data.getName());
        studentname.setText(data.getName());
    }


}
