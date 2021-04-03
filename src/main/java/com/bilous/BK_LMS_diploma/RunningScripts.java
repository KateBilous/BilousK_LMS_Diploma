package com.bilous.BK_LMS_diploma;

import java.sql.Connection;
import java.sql.DriverManager;

public class ScriptRunner {

    public static void main(String[] args) throws Exception {

        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/talakai_noppi";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner();
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("E:\\sampleScript.sql"));
        //Running the script
        sr.runScript(reader);

    }


}
