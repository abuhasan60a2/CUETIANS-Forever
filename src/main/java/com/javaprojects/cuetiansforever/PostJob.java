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

public class PostJob {
    private Stage stage;
    private Scene scene;
    private db job;
    @FXML
    private TextField jobtitle;
    @FXML
    private TextArea jobdescription;

    public void PostJobOnSubmit(ActionEvent e) throws IOException, SQLException {
        String title = jobtitle.getText();
        String description = jobdescription.getText();
        long postid = db.cuetian.getStudentId();
        db.postjob(title, description, postid);
        backtohome(e);

    }
    public void backtohome(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("Alumni"));
        stage.setScene(scene);
        stage.show();
    }
}
