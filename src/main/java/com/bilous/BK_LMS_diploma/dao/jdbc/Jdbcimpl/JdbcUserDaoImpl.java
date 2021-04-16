package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils;
import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.User;
import com.bilous.BK_LMS_diploma.dao.model.UserDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils.createConnection;

public class JdbcUserDaoImpl implements UserDao {
    //TODO connection JDBC instead Persistence

    Logger logger = LogManager.getLogger(JdbcConnectionUtils.class);

    Connection connection = createConnection();

    Statement statement;

    {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<User> getAll() {

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM USERS ;");
            while (rs.next()) {
                int id = rs.getInt(1);
                String role = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                Date dateOfBirth = rs.getDate(5);
                Time lastUpdatedTime = rs.getTime(6);
                Time entryTime = rs.getTime(7);
                User user = new User(firstName, lastName, dateOfBirth);
                System.out.println("id " + id + " role " + role + " firstName " + firstName
                        + " lastName " + lastName + " DOB " + dateOfBirth +
                        " entryTime " + entryTime + " lastUpdateTime " + lastUpdatedTime);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.warn("SQL exception message" + ex.getMessage());
            logger.warn("SQLException SQL state" + ex.getSQLState());
            logger.warn("SQLException error code" + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    logger.warn("Error of reading DB" + ex.getMessage());

                }
            }
        }

        return null;
    }

    @Override
    public User saveUser(User user) {
        PreparedStatement prepStat = null;
        try {
            prepStat = connection.prepareStatement("INSERT INTO USERS (firstName, lastName,dateOfBirth) VALUES" +
                    " (?, ?, ?)");
            prepStat.setString(1, user.getFirstName());
            prepStat.setString(2, user.getLastName());
            prepStat.setDate(3, (Date) user.getDateOfBirth());
            prepStat.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.warn("SQL exception message" + ex.getMessage());
            logger.warn("SQLException SQL state" + ex.getSQLState());
            logger.warn("SQLException error code" + ex.getErrorCode());
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException ex) {
                    logger.warn("Error of reading DB" + ex.getMessage());

                }
            }

        }
        return null;
    }


    @Override
    public User getUserById(int id) {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {

            prepStat = connection.prepareStatement("SELECT FIRSTNAME FROM USERS WHERE userId = ?");

            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println("User name by userId is " + name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.warn("SQL exception message" + ex.getMessage());
            logger.warn("SQLException SQL state" + ex.getSQLState());
            logger.warn("SQLException error code" + ex.getErrorCode());
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException ex) {
                    logger.warn("Error of reading DB" + ex.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public boolean updateUserById(User user, int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("UPDATE  USERS  SET FIRSTNAME =?, LASTNAME=?,DATEOFBIRTH =? WHERE USERID =?");
                prepStat.setInt(4, id);
                prepStat.setString(1, user.getFirstName());
                prepStat.setString(2, user.getLastName());
                prepStat.setDate(3, (Date) user.getDateOfBirth());
                prepStat.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (prepStat != null) {
                    assert false;
                    prepStat.close();
                } else {
                    System.out.println("Impossible read data from DB");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;
    }


    @Override
    public boolean deleteUserById(int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("DELETE FROM  USERS  WHERE USERID = ?");
                prepStat.setInt(1, id);
                prepStat.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (prepStat != null) {
                    assert false;
                    prepStat.close();
                } else {
                    System.out.println("Impossible read data from DB");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;
    }
}
