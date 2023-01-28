package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class AlumniPostedJobRowController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label jobtitle;
    @FXML
    private Label jobdescription;
    @FXML
    private Button viewjobdashboard;
//    @FXML
//    AnchorPane jobrow;
    ResourceBundle saved_resources;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(resourceBundle.getString("jobtitle"));
        jobtitle.setText(resourceBundle.getString("jobtitle"));
        jobdescription.setText(resourceBundle.getString("jobdescription"));
        this.saved_resources = resourceBundle;
    }

    public void deletejobonclick(ActionEvent event) throws IOException, SQLException {
        Connection source = db.makeConnections();
        PreparedStatement st = source.prepareStatement("DELETE FROM javadb_job WHERE cuetian_post_id = ? AND job_title = ? AND job_description = ?");
        st.setLong(1, db.cuetian.getStudentId());
        st.setString(2, jobtitle.getText());
        st.setString(3, jobdescription.getText());
        st.execute();
        st.close();

    }
}
