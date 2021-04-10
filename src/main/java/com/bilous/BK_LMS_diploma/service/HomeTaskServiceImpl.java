package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.HomeTask;
import com.bilous.BK_LMS_diploma.dao.Lesson;
import com.bilous.BK_LMS_diploma.dao.model.HomeTaskDao;

import java.time.LocalDate;

public class HomeTaskServiceImpl implements HomeTaskService{

    private final HomeTaskDao homeTaskDao;

    public HomeTaskServiceImpl(HomeTaskDao homeTaskDao) {
        this.homeTaskDao = homeTaskDao;
    }

    @Override
    public HomeTask createHomeTask(Lesson lesson, int task, LocalDate date, String materials, LocalDate deadline) {
        return new HomeTask(lesson,task,date,materials,deadline);
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) {
        return homeTaskDao.saveHomeTask(homeTask);
    }


}
