package com.bilous.BK_LMS_diploma.dao.factory;

import com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl.JdbcFeedDaoImpl;
import com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl.InMemoryFeedDaoImpl;

public class FeedDaoFactory {

    public InMemoryFeedDaoImpl getImMemoryFeedDao(){
        return new InMemoryFeedDaoImpl() ;
    }

    public JdbcFeedDaoImpl getJdbcFeedDao() {
        return new JdbcFeedDaoImpl();
    }
}
