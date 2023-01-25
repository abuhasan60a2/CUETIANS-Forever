package com.javaprojects.cuetiansforever;

import com.mysql.cj.jdbc.DatabaseMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.Event;
import Backend.*;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import com.javaprojects.cuetiansforever.HelloApplication;
import org.controlsfx.control.action.Action;
import org.w3c.dom.Text;

import static com.javaprojects.cuetiansforever.DatabaseConnection.dbconnect;
import static com.javaprojects.cuetiansforever.HelloApplication.loadFXML;
import Backend.JavadbCuetian;
import Backend.db;
import com.javaprojects.cuetiansforever.Student;
public class Home {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField studentid;
    @FXML
    private PasswordField password;
    @FXML
    private Button signin;
    @FXML
    private Button registration;
    @FXML
    private Label messagelabel;
    public static int student_id;
    public static String login_password;
    public static String student_status;
    public static String name;
    public static String getName(){
        return name;
    }
    private boolean successful_login;
    public Student student = new Student();
    public void changetoreg(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loadFXML("register"));
        stage.setScene(scene);
        stage.show();
    }
    public void login(ActionEvent event) throws IOException {
        if(studentid.getText().isBlank()==false && password.getText().isBlank()==false){
            successful_login = db.login(Integer.parseInt(studentid.getText()), password.getText());
            String name = db.cuetian.getFirstName() + " " + db.cuetian.getLastName();
            System.out.println(name);
            if(successful_login == true){
                String student_status = db.cuetian.getStudentStatus();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                if(Objects.equals(student_status, "A")){
                    scene = new Scene(loadFXML("Alumni"));

                }
                else {
                    scene = new Scene(loadFXML("Student"));
                    student.settextinlabel(name);
                }
                stage.setScene(scene);
                stage.show();
            }
            else{
                messagelabel.setText("Invalid credintials");
            }
        }
        else{
            messagelabel.setText("Enter your credintials");
        }
    }
//    public void validadateLogin(ActionEvent event) {
//        DatabaseConnection connect = new DatabaseConnection();
//        Connection connectDB = connect.makeConnections();
//        try{
//            PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM javadb_cuetian WHERE student_id = ? AND password = ?");
//            statement.setString(2,password.getText());
//            statement.setInt(1,Integer.parseInt(studentid.getText()));
//            ResultSet queryresult = statement.executeQuery();
//
//            while(queryresult.next()){
//
//
//                String s = queryresult.getString("student_status");
////                System.out.println(s);
//                if(queryresult.getInt("student_id")==Integer.parseInt(studentid.getText())){
//                    student_id = Integer.parseInt(studentid.getText());
//                    login_password = password.getText();
//                    String first_name = queryresult.getString("first_name");
//                    String last_name = queryresult.getString("last_name");
//                    name = first_name + " " + last_name;
////                    System.out.println(name);
//                    student_status = s;
//                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                    if(Objects.equals(s, "A")){
//                        scene = new Scene(loadFXML("Alumni"));
//                    }
//                    else {
//                        scene = new Scene(loadFXML("Student"));
//                    }
//                    stage.setScene(scene);
//                    stage.show();
//                }else{
//                    messagelabel.setText("Invalid credintials");
//                }
//
//            }
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }

}
