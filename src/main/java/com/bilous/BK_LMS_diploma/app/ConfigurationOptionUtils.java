package com.bilous.BK_LMS_diploma.app;

import com.bilous.BK_LMS_diploma.dao.factory.DaoType;
import org.apache.commons.cli.*;


public class ConfigurationOptionUtils {

    public static final String DB = "db";
    public static final String INIT_DB = "initDb";
    public static final String POPULATE_DB = "populateDb";
    public static final String MEM = "mem";
    public static final String JDBC = "jdbc";

    public static Configuration resolveConfig(String[] args) {
        Options options = new Options();
        options.addRequiredOption(DB, "daoType", true, "Desired way to persist information");
        options.addOption(INIT_DB, null, false, "Use it if new DB is needed.");
        options.addOption(POPULATE_DB, null, false, "Pre-create some data to work with.");
        Configuration config = null;
        try {
            CommandLine cmd = new DefaultParser().parse(options, args);
            config = resolveConfig(cmd);
            return config;
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }


    private static Configuration resolveConfig(CommandLine cmd) {
        DaoType daoType;
        boolean initDb = false;
        boolean populateDb = false;

        String dbOption = cmd.getOptionValue(DB);
        if (MEM.equalsIgnoreCase(dbOption)) {
            daoType = DaoType.IN_MEMORY;
        } else if (JDBC.equalsIgnoreCase(dbOption)) {
            daoType = DaoType.JDBC;
        } else {
            throw new RuntimeException("could not match cmd argument:" + dbOption + " to available db types");
        }
        if (cmd.hasOption(INIT_DB)) {
            initDb = true;
        }
        if (cmd.hasOption(POPULATE_DB)) {
            populateDb = true;
        }
        return new Configuration(daoType, initDb, populateDb);
    }
}


