package com.bilous.BK_LMS_diploma.app;

import com.bilous.BK_LMS_diploma.dao.factory.DaoType;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils.createConnection;

public class AppPopulateSqlUtils {

    //private static final Logger log = LogManager.getLogManager().getLogger(AppPopulateSqlUtils.class);

    public static void initDatabase(Configuration configuration) {
        if (configuration.IsInitDb()) {
            if (configuration.getDaoType() == DaoType.JDBC) {
                AppPopulateSqlUtils.initDb();
            }
        }
        if (configuration.IsPopulateDb()) {
            if (configuration.getDaoType() == DaoType.JDBC) {
                AppPopulateSqlUtils.populateJdbcDb();
            } else {
                AppPopulateSqlUtils.populateInMemory();
            }
        }
    }

    private static void populateInMemory() {
        String query = parseQuery("src/main/resources/populate.sql");
        Persistence persistence = Persistence.getInstance();
       // try{
         //   Statement statement = persistence.
        //}
        //TODO use file from cmd branch
    }

    private static void populateJdbcDb() {
        String query = parseQuery("src/main/resources/populate.sql");
        Connection connection = createConnection();
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void initDb() {
        String query = parseQuery("src/main/resources/createtable.sql");
        Connection connection = createConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static String parseQuery(String path) {
        String query = null;

        try{
            query = String.join("", Files.readAllLines(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }return query;

    }

}
