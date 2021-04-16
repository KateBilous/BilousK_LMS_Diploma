package com.bilous.BK_LMS_diploma.dao.factory;

import com.bilous.BK_LMS_diploma.dao.factory.GroupDaoFactory;
import com.bilous.BK_LMS_diploma.dao.factory.LessonDaoFactory;
import com.bilous.BK_LMS_diploma.dao.model.FeedDao;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.LessonDao;
import com.bilous.BK_LMS_diploma.dao.model.UserDao;

import static com.bilous.BK_LMS_diploma.app.ConfigurationOptionUtils.JDBC;
import static com.bilous.BK_LMS_diploma.dao.factory.DaoType.IN_MEMORY;

public class DaoAbstractFactory {


    private final GroupDaoFactory groupDaoFactory;
    private final LessonDaoFactory lessonDaoFactory;
    private final UserDaoFactory userDaoFactory;
    private final FeedDaoFactory feedDaoFactory;
    private final DaoType daoType;

    public DaoAbstractFactory(DaoType type) {
        this.groupDaoFactory = new GroupDaoFactory();
        this.lessonDaoFactory = new LessonDaoFactory();
        this.userDaoFactory = new UserDaoFactory();
        this.feedDaoFactory = new FeedDaoFactory();
        this.daoType = type;
    }

    public GroupDao createGroupDao() {
        if (IN_MEMORY.equals(daoType)) {
            return groupDaoFactory.getImMemoryGroupDao();
        }
        if (JDBC.equals(daoType)) {
            return  groupDaoFactory.getJdbcGroupDao();
        }
        return null;

    }

    public LessonDao createLessonDao() {
        if (IN_MEMORY.equals(daoType)) {
            return lessonDaoFactory.getImMemoryLessonDao();
        }
        if (JDBC.equals(daoType)) {
            return lessonDaoFactory.getJdbcLessonDao();
        }
        return null;

    }

    public UserDao createUserDao() {
        if (IN_MEMORY.equals(daoType)) {
            return userDaoFactory.getImMemoryUserDao();
        }
        if (JDBC.equals(daoType)) {
            return userDaoFactory.getJdbcUserDao();
        }
        return null;

    }


    public FeedDao createFeedDao() {
        if (IN_MEMORY.equals(daoType)) {
            return feedDaoFactory.getImMemoryFeedDao();
        }
        if (JDBC.equals(daoType)) {
            return feedDaoFactory.getJdbcFeedDao();
        }
        return null;

    }
}
