package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.model.HomeTaskDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryHomeTask  implements HomeTaskDao {


    @Override
    public List<HomeTask> getAll() {
        return new ArrayList<>(Storage.getHomeTasks().values());
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) {
        int newId = Storage.getNewHomeTaskId();
        homeTask.setId(newId);
        return Storage.getHomeTasks().put(homeTask.getId(), homeTask);
    }


    @Override
    public HomeTask getHomeTaskById(int id) {
        return Storage.getHomeTasks().get(id);

    }

    @Override
    public boolean updateHomeTaskById(HomeTask homeTask, int id) {
        Map<Integer, HomeTask> homeTasks = Storage.getHomeTasks();
        if (homeTasks.containsKey(homeTask.getId())) {
            homeTasks.put(homeTask.getId(), homeTask);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeTaskById(int id) {
        Map<Integer, HomeTask> homeTasks = Storage.getHomeTasks();
        if (homeTasks.containsKey(id)) {
            homeTasks.remove(id);
            return true;
        }
        return false;
    }
}
