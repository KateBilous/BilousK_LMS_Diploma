package com.bilous.BK_LMS_diploma.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

public class JdbcConnectionUtils {
    static String H2_URL = "jdbc:h2:file://Users/ekaterina.bilous/Documents/Diploma_Java_Elementary/BilousK_LMS_Diploma/src/main/java/com/bilous/BK_LMS_diploma/persistence/db";
    //static String H2_URL = "jdbc:h2:://localhost:9092/default";

    public static Connection createConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("H2 Driver is not found");
            e.printStackTrace();

        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(H2_URL);
        } catch (
                SQLException e) {
            System.out.println("Connection Failed : " + e.getMessage());

        }
        if (connection != null) {

        } else System.out.println("Failed to make connection!");
        return connection;


    }


}
