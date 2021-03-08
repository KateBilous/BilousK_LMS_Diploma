package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.model.GroupDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryGroupDaoImpl implements GroupDao {

    @Override
    public List<Group> getAll() {
        return new ArrayList<>(Storage.getGroups().values());
    }

    @Override
    public Group saveGroup(Group group) {
        int newId = Storage.getNewGroupId();
        group.setId(newId);
        return Storage.getGroups().put(group.getId(), group);
    }

    @Override
    public Group getGroupById(int id) {
        return Storage.getGroups().get(id);
    }



    @Override
    public boolean updateGroupById(Group group, int id) {
        Map<Integer, Group> groups = Storage.getGroups();
        if (groups.containsKey(group.getId())) {
            groups.put(group.getId(), group);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteGroupById(int id) {
        Map<Integer, Group> groups = Storage.getGroups();
        if (groups.containsKey(id)) {
            groups.remove(id);
            return true;


        }
        return false;
    }
}
