package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.HomeWork;
import com.bilous.BK_LMS_diploma.domain.model.HomeworkDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryHomeWorkDaoImpl implements HomeworkDao {


    @Override
    public List<HomeWork> getAll() {
        return new ArrayList<>(Persistence.getInstance().getHomeWork().values());
    }

    @Override
    public HomeWork saveHomeWork(HomeWork homeWork) {
        HomeWork savedHomeWork = buildHomeWorkFromTemplate(homeWork);
        int newId = Persistence.getInstance().getNewHomeWorkId();
        savedHomeWork.setId(newId);
        Persistence.getInstance().getHomeWork().put(newId, savedHomeWork);
        return savedHomeWork;
    }

    private HomeWork buildHomeWorkFromTemplate(HomeWork homeWork) {
        HomeWork newHomeWork = new HomeWork(homeWork.getHomeTasks(), homeWork.getScore(), homeWork.getResolution(),
                homeWork.getAuthor());
        newHomeWork.setHomeTasks(homeWork.getHomeTasks());
        newHomeWork.setScore(homeWork.getScore());
        newHomeWork.setResolution(homeWork.getResolution());
        newHomeWork.setAuthor(homeWork.getAuthor());
        return newHomeWork;
    }

    @Override
    public HomeWork getHomeWorkById(int id) {
        return Persistence.getInstance().getHomeWork().get(id);

    }

    @Override
    public boolean updateHomeWork(HomeWork homeWork) {
        int id = homeWork.getId();
        Map<Integer, HomeWork> homeworks = Persistence.getInstance().getHomeWork();
        if (homeworks.containsKey(id)) {
            homeworks.put(id, homeWork);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateHomeWorkById(HomeWork homeWork) {
        int id = homeWork.getId();
        Map<Integer, HomeWork> homeworks = Persistence.getInstance().getHomeWork();
        if (homeworks.containsKey(id)) {
            homeworks.put(id, homeWork);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeWorkById(int id) {
        Map<Integer, HomeWork> homeworks = Persistence.getInstance().getHomeWork();
        if (homeworks.containsKey(id)) {
            homeworks.remove(id);
            return true;
        }
        return false;
    }
}
