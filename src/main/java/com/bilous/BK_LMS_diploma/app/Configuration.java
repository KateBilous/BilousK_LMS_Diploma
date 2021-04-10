package com.bilous.BK_LMS_diploma.app;

import com.bilous.BK_LMS_diploma.dao.factory.DaoType;

public class Configuration {

    private final DaoType daoType;
    private final boolean initDb;
    private final boolean populateDb;


    public Configuration(DaoType daoType, boolean initDb, boolean populateDb) {
        this.daoType =daoType;
        this.initDb = initDb;
        this.populateDb = populateDb;
    }

    public DaoType getDaoType() {
        return daoType;
    }

    public boolean IsInitDb() {
        return initDb;
    }

    public boolean IsPopulateDb() {
        return populateDb;
    }


}




