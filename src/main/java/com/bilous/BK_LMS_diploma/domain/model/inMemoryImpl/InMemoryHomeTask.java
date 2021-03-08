package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.model.HomeTaskDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryHomeTask  implements HomeTaskDao {


    @Override
    public List<HomeTask> getAll() {
        return new ArrayList<>(Persistence.getInstance().getHomeTask().values());
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) {
        HomeTask savedHomeTask = buildHomeTaskFromTemplate(homeTask);
        int newId = Persistence.getInstance().getNewHomeTaskId();
        savedHomeTask.setId(newId);
        Persistence.getInstance().getHomeTask().put(newId, savedHomeTask);
        return savedHomeTask;
    }

    private HomeTask buildHomeTaskFromTemplate(HomeTask homeTask) {
        HomeTask newHomeTask = new HomeTask( homeTask.getLesson(), homeTask.getRetake(), homeTask.getDate(),
                homeTask.getMaterials(), homeTask.getDedLine());
        newHomeTask.setLesson(homeTask.getLesson());
        newHomeTask.setRetake(homeTask.getRetake());
        newHomeTask.setDate(homeTask.getDate());
        newHomeTask.setMaterials(homeTask.getMaterials());
        newHomeTask.setDedLine(homeTask.getDedLine());
        return newHomeTask;
    }

    @Override
    public HomeTask getHomeTaskById(int id) {
        return Persistence.getInstance().getHomeTask().get(id);

    }

    @Override
    public boolean updateHomeTask(HomeTask homeTask) {
        int id = homeTask.getId();
        Map<Integer, HomeTask> homeTasks = Persistence.getInstance().getHomeTask();
        if (homeTasks.containsKey(id)) {
            homeTasks.put(id, homeTask);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateHomeTaskById(HomeTask homeTask) {
        int id = homeTask.getId();
        Map<Integer, HomeTask> homeTasks = Persistence.getInstance().getHomeTask();
        if (homeTasks.containsKey(id)) {
            homeTasks.put(id, homeTask);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeTaskById(int id) {
        Map<Integer, HomeTask> homeTasks = Persistence.getInstance().getHomeTask();
        if (homeTasks.containsKey(id)) {
            homeTasks.remove(id);
            return true;
        }
        return false;
    }
}
