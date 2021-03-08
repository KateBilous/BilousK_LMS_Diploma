package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.model.GroupDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryGroupDaoImpl implements GroupDao {

    @Override
    public List<Group> getAll() {
        return new ArrayList<>(Persistence.getInstance().getGroup().values());
    }

    @Override
    public Integer saveGroup(Group group) {
        Group savedGroup = buildGroupFromTemplate(group);
        int newId = Persistence.getInstance().getNewGroupId();
        savedGroup.setId(newId);
        Persistence.getInstance().getGroup().put(newId, savedGroup);
        return savedGroup;
    }

    private Group buildGroupFromTemplate(Group group) {
        Group newGroup = new Group(group.getName(), group.getDirection(), group.getStartDate());
        newGroup.setStudents(group.getStudents());
        newGroup.setTeachers(group.getTeachers());
        newGroup.getFeed().getPosts().addAll(group.getFeed().getPosts());
        newGroup.getLessons().addAll(group.getLessons());
        return newGroup;
    }

    @Override
    public Group getGroupById(int id) {
        return Persistence.getInstance().getGroup().get(id);

    }

    @Override
    public boolean updateGroup(Group group) {
        int id = group.getId();
        Map<Integer, Group> groups = Persistence.getInstance().getGroup();
        if (groups.containsKey(id)) {
            groups.put(id, group);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateGroupById(Group group) {
        int id = group.getId();
        Map<Integer, Group> groups = Persistence.getInstance().getGroup();
        if (groups.containsKey(id)) {
            groups.put(id, group);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteGroupById(int id) {
        Map<Integer, Group> groups = Persistence.getInstance().getGroup();
        if (groups.containsKey(id)) {
            groups.remove(id);
            return true;


        }
        return false;
    }
}
