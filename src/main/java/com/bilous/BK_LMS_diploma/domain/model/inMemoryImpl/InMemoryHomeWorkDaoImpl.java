package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.HomeWork;
import com.bilous.BK_LMS_diploma.domain.model.HomeworkDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryHomeWorkDaoImpl implements HomeworkDao {


    @Override
    public List<HomeWork> getAll() {
        return new ArrayList<>(Storage.getHomeWorks().values());
    }

    @Override
    public HomeWork saveHomeWork(HomeWork homeWork) {
        int newId = Storage.getNewHomeWorkId();
        homeWork.setId(newId);
        return Storage.getHomeWorks().put(homeWork.getId(), homeWork);
    }


    @Override
    public HomeWork getHomeWorkById(int id) {
        return Storage.getHomeWorks().get(id);

    }


    @Override
    public boolean updateHomeWorkById(HomeWork homeWork, int id) {
        Map<Integer, HomeWork> homeworks = Storage.getHomeWorks();
        if (homeworks.containsKey(homeWork.getId())) {
            homeworks.put(homeWork.getId(), homeWork);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteHomeWorkById(int id) {
        Map<Integer, HomeWork> homeworks = Storage.getHomeWorks();
        if (homeworks.containsKey(id)) {
            homeworks.remove(id);
            return true;
        }
        return false;
    }
}
