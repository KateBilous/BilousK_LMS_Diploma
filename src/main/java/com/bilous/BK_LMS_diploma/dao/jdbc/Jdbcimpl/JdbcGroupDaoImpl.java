package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import static com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils.createConnection;

import com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils;
import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JdbcGroupDaoImpl implements GroupDao {

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
    public List<Group> getAll() {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM GROUPS ;");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String direction = rs.getString(3);
                Date startDate = rs.getDate(4);
                Time lastUpdateTime = rs.getTime(5);
                Time entryTime = rs.getTime(6);
                Group group = new Group(name, direction, startDate);
                System.out.println("id " + id + " name " + name + " direction " + direction
                        + " startDate " + startDate + " LastUpdateTime " + lastUpdateTime +
                        " entryTime " + entryTime);
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
    public Group saveGroup(Group group) {
        PreparedStatement prepStat = null;
        try {
            prepStat = connection.prepareStatement("INSERT INTO groups (name, direction,startDate) VALUES (?, ?, ?)");
            prepStat.setString(1, group.getName());
            prepStat.setString(2, group.getDirection());
            prepStat.setDate(3, (Date) group.getStartDate());
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
    public Group getGroupById(int id) {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {

            prepStat = connection.prepareStatement("SELECT NAME FROM groups WHERE GROUPID = ?");

            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println("Group name by Id is " + name);
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
    public boolean updateGroupById(Group group, int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("UPDATE  GROUPS  SET NAME =?, direction=?,startDate=? WHERE GROUPID =?");
                prepStat.setInt(4, id);
                prepStat.setString(1, group.getName());
                prepStat.setString(2, group.getDirection());
                prepStat.setDate(3, (Date) group.getStartDate());
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
    public boolean deleteGroupById(int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("DELETE FROM  GROUPS  WHERE GROUPID = ?");
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
