package com.javaprojects.cuetiansforever;

import Backend.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;

public class JobDetailsController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label jobtitle;
    @FXML
    private Text jobdescription;
    @FXML
    private Text text;
    @FXML
    private ImageView image;
    @FXML
    private Label applyerror;
    private long job_seek_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image.setImage(new Image((new File("src/cuetlogo.png").getAbsolutePath())));
         long job_id  = Long.parseLong(resourceBundle.getString("id"));
        job_seek_id = job_id;
        System.out.println(resourceBundle.getString("id"));
//        System.out.println(image.getImage().getUrl());
        try {
            Connection source  = db.makeConnections();

            PreparedStatement st = source.prepareStatement("SELECT * FROM javadb_job WHERE id = ?");
           st.setLong(1,job_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            jobtitle.setText(resourceBundle.getString("jobtitle"));
            jobdescription.setText(resourceBundle.getString("jobdescription"));
//            System.out.println(jobdescription.getText());

        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

    }
    public void returntojobboard(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("JobBoard"));
        stage.setScene(scene);
        stage.show();
    }
    public void ApplytoJob(ActionEvent event) throws IOException{
        try {
            Connection source = db.makeConnections();
            PreparedStatement st = source.prepareStatement("SELECT  * FROM  `javadb_job_cuetian_seek` WHERE job_id = ? AND  cuetian_id = ?");
            st.setLong(1,job_seek_id);
            System.out.println(job_seek_id);
            st.setLong(2,db.cuetian.getStudentId());
            System.out.println(db.cuetian.getStudentId());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                applyerror.setText("You can only apply for a job once!");
            }
            else{
                PreparedStatement st2 = source.prepareStatement("INSERT INTO `javadb_job_cuetian_seek` ( `job_id`, `cuetian_id`) VALUES ( ?, ?)");
                st2.setLong(1,job_seek_id);
                st2.setLong(2,db.cuetian.getStudentId());
                st2.execute();
                st2.close();
                returntojobboard(event);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
