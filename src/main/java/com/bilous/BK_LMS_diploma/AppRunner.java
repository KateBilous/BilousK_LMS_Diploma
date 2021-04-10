package com.bilous.BK_LMS_diploma;

import com.bilous.BK_LMS_diploma.app.Configuration;
import com.bilous.BK_LMS_diploma.app.ConfigurationOptionUtils;
import com.bilous.BK_LMS_diploma.dao.factory.DaoType;
import com.bilous.BK_LMS_diploma.persistence.DaoContext;

import static com.bilous.BK_LMS_diploma.app.AppPopulateSqlUtils.initDatabase;

public class AppRunner {

    public static void main(String[] args) {


        Configuration configuration = ConfigurationOptionUtils.resolveConfig(args);
        DaoContext daoContext1 = DaoContext.getInstance(configuration.getDaoType());
        initDatabase(configuration);




    }
}
