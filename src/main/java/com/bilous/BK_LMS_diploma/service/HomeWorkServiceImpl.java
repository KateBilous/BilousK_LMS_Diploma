package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.HomeTask;
import com.bilous.BK_LMS_diploma.dao.HomeWork;
import com.bilous.BK_LMS_diploma.dao.model.HomeworkDao;

public class HomeWorkServiceImpl implements HomeWorkService {

    private final HomeworkDao homeworkDao;

    public HomeWorkServiceImpl(HomeworkDao homeworkDao) {
        this.homeworkDao = homeworkDao;
    }

    @Override
    public HomeWork createHomework(HomeTask homeTasks, int score, String resolution, String author) {
        return new HomeWork(homeTasks, score,resolution,author);
    }

    @Override
    public HomeWork saveHomework(HomeWork homeWork) {
        return homeworkDao.saveHomeWork(homeWork);
    }
}
