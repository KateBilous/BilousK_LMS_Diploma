package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.dao.HomeWork;
import com.bilous.BK_LMS_diploma.dao.model.HomeworkDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcHomeWorkDaoImpl implements HomeworkDao {
    //TODO connection JDBC instead Persistence


    @Override
    public List<HomeWork> getAll() {
        return new ArrayList<>(Persistence.getInstance().getHomeWorks().values());
    }

    @Override
    public HomeWork saveHomeWork(HomeWork homeWork) {
        int newId = Persistence.getInstance().getNewHomeWorkId();
        homeWork.setId(newId);
        return Persistence.getInstance().getHomeWorks().put(homeWork.getId(), homeWork);
    }


    @Override
    public HomeWork getHomeWorkById(int id) {
        return Persistence.getInstance().getHomeWorks().get(id);

    }

    @Override
    public boolean updateHomeWorkById(HomeWork homeWork, int id) {
        Map<Integer, HomeWork> homeWorks = Persistence.getInstance().getHomeWorks();
        if (homeWorks.containsKey(homeWork.getId())) {
            homeWorks.put(homeWork.getId(), homeWork);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteHomeWorkById(int id) {
        Map<Integer, HomeWork> homeworks = Persistence.getInstance().getHomeWorks();
        if (homeworks.containsKey(id)) {
            homeworks.remove(id);
            return true;
        }
        return false;
    }
}
