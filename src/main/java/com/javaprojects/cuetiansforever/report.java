package com.javaprojects.cuetiansforever;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;
import Backend.db;
public class report {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField jobtitle;
    @FXML
    private TextArea jobdescription;
    public void PostReportonClick(ActionEvent event) throws IOException, SQLException {
        String title = jobtitle.getText();
        String description = jobdescription.getText();
        long cuetianid = db.cuetian.getStudentId();
        db.postReport( title, description, cuetianid);
        backtohome(event);
    }
    public void backtohome(ActionEvent event) throws IOException {
        String student_status  = db.cuetian.getStudentStatus();
        System.out.println(student_status);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(student_status.equals("A")){
            scene = new Scene(loadFXML("Alumni"));
        }
        else{
            scene = new Scene(loadFXML("Student"));
        }
        stage.setScene(scene);
        stage.show();

    }
}
