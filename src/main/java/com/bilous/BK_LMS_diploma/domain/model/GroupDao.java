package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAll();

    Integer saveGroup(Group group);

    Group getGroupById(int id);

    boolean updateGroup(Group group);

    boolean updateGroupById(Group group);

    boolean deleteGroupById(int id);

}
