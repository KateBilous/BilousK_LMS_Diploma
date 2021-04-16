package com.bilous.BK_LMS_diploma.persistence;

import com.bilous.BK_LMS_diploma.dao.factory.DaoAbstractFactory;
import com.bilous.BK_LMS_diploma.dao.factory.DaoType;
import com.bilous.BK_LMS_diploma.dao.model.FeedDao;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.LessonDao;
import com.bilous.BK_LMS_diploma.dao.model.UserDao;

public class DaoContext {

    private static DaoContext instance;

    private final GroupDao groupDao;
    private final LessonDao lessonDao;
    private final UserDao userDao;
    private final FeedDao feedDao;


    private DaoContext (DaoType type){
        DaoAbstractFactory factory = new DaoAbstractFactory(type);
        this.groupDao = factory.createGroupDao();
        this.lessonDao = factory.createLessonDao();
        this.userDao = factory.createUserDao();
        this.feedDao = factory.createFeedDao();

    }


    public static DaoContext getInstance(DaoType type) {
        if(instance== null){
            instance = new DaoContext(type);
        }
        return instance;
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public LessonDao getLessonDao() {
        return lessonDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public FeedDao getFeedDao() {
        return feedDao;
    }
}
