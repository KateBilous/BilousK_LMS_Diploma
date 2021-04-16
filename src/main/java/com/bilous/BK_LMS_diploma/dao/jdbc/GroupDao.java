package com.bilous.BK_LMS_diploma.dao.jdbc;

import com.bilous.BK_LMS_diploma.dao.Group;

import java.sql.ResultSet;
import java.util.List;

public interface GroupDao {


        ResultSet getAll();

        Group saveGroup(Group group);

        Group getGroupById(int id);

        boolean updateGroupById(Group group, int id);

        boolean deleteGroupById(int id);

    }

