package com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryGroupDaoImpl implements GroupDao {

    @Override
    public List<Group> getAll() {
        return new ArrayList<>(Persistence.getInstance().getGroups().values());
    }

    @Override
    public Group saveGroup(Group group) {
        int newId = Persistence.getInstance().getNewGroupId();
        group.setId(newId);
        return Persistence.getInstance().getGroups().put(group.getId(), group);
    }

    @Override
    public Group getGroupById(int id) {
        return Persistence.getInstance().getGroups().get(id);

    }



    @Override
    public boolean updateGroupById(Group group, int id) {
        Map<Integer, Group> groups = Persistence.getInstance().getGroups();
        if (groups.containsKey(group.getId())) {
            groups.put(group.getId(), group);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteGroupById(int id) {
        Map<Integer, Group> groups = Persistence.getInstance().getGroups();
        if (groups.containsKey(id)) {
            groups.remove(id);
            return true;


        }
        return false;
    }
}
