package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.Lesson;
import com.bilous.BK_LMS_diploma.domain.model.HomeTaskDao;
import com.bilous.BK_LMS_diploma.domain.model.LessonDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
