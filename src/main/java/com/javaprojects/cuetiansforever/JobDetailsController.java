package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
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
@FXML
private ImageView image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image.setImage(new Image((new File("src/cuetlogo.png").getAbsolutePath())));
        long job_id  = Long.parseLong(resourceBundle.getString("id"));
        System.out.println(image.getImage().getUrl());
        try {
            Connection source  = db.makeConnections();

            PreparedStatement st = source.prepareStatement("SELECT * FROM javadb_job WHERE id = ?");
           st.setLong(1,job_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            jobtitle.setText(resourceBundle.getString("jobtitle"));
            jobdescription.setText(resourceBundle.getString("jobdescription"));

        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

    }
}
