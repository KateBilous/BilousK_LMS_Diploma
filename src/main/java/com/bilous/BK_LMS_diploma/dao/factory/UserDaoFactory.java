package com.bilous.BK_LMS_diploma.dao.factory;

import com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl.JdbcGroupDaoImpl;
import com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl.JdbcUserDaoImpl;
import com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl.InMemoryGroupDaoImpl;
import com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl.InMemoryUserDaoImpl;

public class UserDaoFactory {


    public InMemoryUserDaoImpl getImMemoryUserDao(){
        return new InMemoryUserDaoImpl() ;
    }

    public JdbcUserDaoImpl getJdbcUserDao() {
        return new JdbcUserDaoImpl();
    }
}
