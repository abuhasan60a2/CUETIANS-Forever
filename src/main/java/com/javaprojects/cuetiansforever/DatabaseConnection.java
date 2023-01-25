package com.javaprojects.cuetiansforever;
import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.*;

public class DatabaseConnection {
    public static String db_url = "jdbc:mysql://localhost:3307/cuetiansforever";
    public static String db_name = "cuetiansforeverdb";
    public static String db_username = "root";
    public static String db_password = "";
    public static Connection dbconnect = null;
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
