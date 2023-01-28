package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class JobDetailsController implements Initializable {
    @FXML
    private Label jobtitle;
    @FXML
    private Text jobdescription;
    @FXML
    private Text text;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // long job_id  = Long.parseLong(resourceBundle.getString("id"));
        //System.out.println(job_id);
        try {
            Connection source  = db.makeConnections();

            PreparedStatement st = source.prepareStatement("SELECT * FROM javadb_job WHERE job_title = ? AND job_description = ?");
           // st.setLong(1, job_id);
            st.setString(1, resourceBundle.getString("jobtitle"));
            st.setString(2,resourceBundle.getString("jobdescription"));
            ResultSet rs = st.executeQuery();
            rs.next();
            jobtitle.setText(resourceBundle.getString("jobtitle"));
            jobtitle.setText(resourceBundle.getString("jobdescription"));

        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

    }
}
