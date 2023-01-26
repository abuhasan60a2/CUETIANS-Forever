package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    public static String db_url = "jdbc:mysql://localhost:3307/cuetiansforever";
    public static String db_name = "cuetiansforeverdb";
    public static String db_username = "root";
    public static String db_password = "";
    public static Connection dbconnect = null;
    public static JavadbCuetian cuetian = null;
    public static JavadbJob job  = null;
    public static JavadbReport report = null;
    //functions for report


    public static void postReport(String title, String description, long postid) throws SQLException{
        JavadbReport.InsertReportData(title, description, postid);
    }

    //functions for job portal
    public static void setJob(JavadbJob _job){
        job = _job;
    }
    public static void postjob(String jobtitle, String description, long postid) throws SQLException {
        JavadbJob.insertjobdata(jobtitle, description, postid);
        System.out.println("db postjob block");
    }

    //functions for cuetian instance
    public static boolean iscuetianavalable(){
        return cuetian !=null;
    }
    public static JavadbCuetian getCuetian(){
        return cuetian;
    }
    public static void setCuetian(JavadbCuetian _cuetian){
        cuetian = _cuetian;
    }
    public static boolean login(long ID, String password){
        cuetian = JavadbCuetian.login(ID, password);
        if(cuetian == null){
            return false;
        }
        return true;

    }
    public static boolean signup(long ID,String firstName, String lastName, String email, String password, long phoneNumber, String department, String studentStatus, long batch, String dob, long age, String presentAddress, String permanentAddress, String joiningYear, String passing_year, String profession, String company, String facebookProfile, String linkedInProfile) throws SQLException {
        cuetian = JavadbCuetian.signup(ID, firstName, lastName, email, password, phoneNumber, department, studentStatus, batch, dob, age, presentAddress, permanentAddress, joiningYear, passing_year, profession, company, facebookProfile, linkedInProfile);
        if(cuetian == null){
            System.out.println("resultset not found");
            return false;
        }
        System.out.println("resultset found");
        return true;
    }
    public static void logout(){
        setCuetian(null);
    }



    //functions for database connectivity
    public static boolean isConnectionAvailable() {
        return dbconnect != null;
    }
    public static Connection makeConnections() {
        if (isConnectionAvailable()) {
            return dbconnect;
        }
        try {
            dbconnect = DriverManager.getConnection("jdbc:mysql://root@localhost:3307/cuetiansforeverdb");
            System.out.printf("Database is %s \n", !dbconnect.isClosed() ? "connected" : "not ok");
            System.out.printf("%s/%s \n", dbconnect.getCatalog(), dbconnect.getSchema());
            return dbconnect;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnections() {
        if (dbconnect != null) {
            try {
                dbconnect.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
    }
}
