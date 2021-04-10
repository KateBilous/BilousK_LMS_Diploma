package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.dao.HomeTask;
import com.bilous.BK_LMS_diploma.dao.model.HomeTaskDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcHomeTask implements HomeTaskDao {
//TODO connection JDBC instead Persistence

    @Override
    public List<HomeTask> getAll() {
        return new ArrayList<>(Persistence.getInstance().getHomeTasks().values());
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) {
        int newId = Persistence.getInstance().getNewHomeTaskId();
        homeTask.setId(newId);
        return Persistence.getInstance().getHomeTasks().put(homeTask.getId(), homeTask);
    }



    @Override
    public HomeTask getHomeTaskById(int id) {
        return Persistence.getInstance().getHomeTasks().get(id);

    }


    @Override
    public boolean updateHomeTaskById(HomeTask homeTask, int id) {
        Map<Integer, HomeTask> homeTasks = Persistence.getInstance().getHomeTasks();
        if (homeTasks.containsKey( homeTask.getId())) {
            homeTasks.put( homeTask.getId(), homeTask);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeTaskById(int id) {
        Map<Integer, HomeTask> homeTasks = Persistence.getInstance().getHomeTasks();
        if (homeTasks.containsKey(id)) {
            homeTasks.remove(id);
            return true;
        }
        return false;
    }
}
