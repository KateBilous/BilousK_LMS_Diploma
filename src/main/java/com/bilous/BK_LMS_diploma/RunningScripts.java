package com.bilous.BK_LMS_diploma;

import org.h2.tools.RunScript;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class RunningScripts {




    public static void run() throws Exception {

        //Registering the Driver
        DriverManager.registerDriver(new org.h2.Driver());
        //Getting the connection
        String h2Url = "jdbc:h2:file://Users/ekaterina.bilous/Documents/Diploma_Java_Elementary/BilousK_LMS_Diploma/Database";
        Connection con = DriverManager.getConnection(h2Url, "", "");
        System.out.println("Connection established......");
        //Initialize the script runner
       //RunningScripts sr = new RunningScripts();
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("/Users/ekaterina.bilous/Documents/Diploma_Java_Elementary/BilousK_LMS_Diploma/SQLScript.sql"));
        //Running the script
        RunScript.execute(con,reader);

    }



}
