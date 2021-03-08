package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAll();

    Group saveGroup(Group group);

    Group getGroupById(int id);

    boolean updateGroupById(Group group, int id);

    boolean deleteGroupById(int id);

}
