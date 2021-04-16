package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils;
import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.Lesson;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.LessonDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bilous.BK_LMS_diploma.app.JdbcConnectionUtils.createConnection;

public class JdbcLessonDaoImpl implements LessonDao {

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
    public List<Lesson> getAll() {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM LESSONS ;");
            while (rs.next()) {
                int lessonId = rs.getInt(1);
                int groupId = rs.getInt(2);
                String topic = rs.getString(3);
                String description = rs.getString(4);
                String materials = rs.getString(5);
                Date scheduled = rs.getDate(6);
                Time lastUpdateTime = rs.getTime(7);
                Time entryTime = rs.getTime(8);
                //Lesson lesson = new Lesson(group, topic, materials);
                System.out.println("lessonId " + lessonId + " groupId " + groupId + " topic " + topic
                        + " description " + description + " materials " + materials +
                        " scheduled" + scheduled + " lastUpdateTime" + lastUpdateTime + " entryTime" + entryTime);
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
    public Lesson saveLesson(Lesson lesson) {
        PreparedStatement prepStat = null;
        try {
            prepStat = connection.prepareStatement("INSERT INTO LESSONS (LESSONID, topic, materials) VALUES (?, ?, ?)");
            prepStat.setInt(1, lesson.getId());
            prepStat.setString(2, lesson.getTopic());
            prepStat.setString(3, lesson.getMaterials());
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
    public Lesson getLessonById(int id) {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {

            prepStat = connection.prepareStatement("SELECT topic FROM LESSONS WHERE LESSONID = ?");

            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println("LESSON name by lessonId is " + name);
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
    public boolean updateLessonById(Lesson lesson, int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("UPDATE  LESSONS  SET topic =?,MATERIALS=? WHERE LESSONID =?");
                prepStat.setInt(3, id);
                prepStat.setString(1, lesson.getTopic());
                prepStat.setString(2, lesson.getMaterials());
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
    public boolean deleteLessonById(int id) {
        try {
            ResultSet rs = null;
            PreparedStatement prepStat = null;
            try {
                prepStat = connection.prepareStatement("DELETE FROM  LESSONS  WHERE LESSONID = ?");
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
