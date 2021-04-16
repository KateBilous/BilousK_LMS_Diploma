package com.bilous.BK_LMS_diploma.dao.factory;

import com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl.JdbcLessonDaoImpl;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl.InMemoryLessonDaoImpl;

public class LessonDaoFactory {


    public InMemoryLessonDaoImpl getImMemoryLessonDao(){
        return new InMemoryLessonDaoImpl() ;
    }

    public JdbcLessonDaoImpl getJdbcLessonDao() {
        return new JdbcLessonDaoImpl();
    }
}
