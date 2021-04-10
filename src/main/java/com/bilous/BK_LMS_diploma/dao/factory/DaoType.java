package com.bilous.BK_LMS_diploma.dao.factory;

public enum DaoType {

    IN_MEMORY("InMemory"),
    JDBC("jdbc");

    private String type;

    DaoType(String type) {
        this.type = type;
    }
}

