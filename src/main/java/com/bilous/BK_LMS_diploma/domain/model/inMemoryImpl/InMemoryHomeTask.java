package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.model.HomeTaskDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryHomeTask  implements HomeTaskDao {


    @Override
    public List<HomeTask> getAll() {
        return new ArrayList<>(Storage.getInstance().getHomeTasks().values());
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) {
        int newId = Storage.getInstance().getNewHomeTaskId();
        homeTask.setId(newId);
        return Storage.getInstance().getHomeTasks().put(homeTask.getId(), homeTask);
    }



    @Override
    public HomeTask getHomeTaskById(int id) {
        return Storage.getInstance().getHomeTasks().get(id);

    }

    @Override
    public boolean updateHomeTask(HomeTask homeTask) {
        int id = homeTask.getId();
        Map<Integer, HomeTask> homeTasks = Storage.getInstance().getHomeTasks();
        if (homeTasks.containsKey(id)) {
            homeTasks.put(id, homeTask);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateHomeTaskById(HomeTask homeTask) {
        int id = homeTask.getId();
        Map<Integer, HomeTask> homeTasks = Storage.getInstance().getHomeTasks();
        if (homeTasks.containsKey(id)) {
            homeTasks.put(id, homeTask);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeTaskById(int id) {
        Map<Integer, HomeTask> homeTasks = Storage.getInstance().getHomeTasks();
        if (homeTasks.containsKey(id)) {
            homeTasks.remove(id);
            return true;
        }
        return false;
    }
}
