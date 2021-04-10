package com.bilous.BK_LMS_diploma.dao.factory;

import com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl.JdbcGroupDaoImpl;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl.InMemoryGroupDaoImpl;

public class GroupDaoFactory {

    public InMemoryGroupDaoImpl getImMemoryGroupDao(){
        return new InMemoryGroupDaoImpl() ;
    }

    public JdbcGroupDaoImpl getJdbcGroupDao() {
        return new JdbcGroupDaoImpl();
    }

}

