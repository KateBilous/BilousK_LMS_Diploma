package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.HomeWork;
import com.bilous.BK_LMS_diploma.domain.model.HomeworkDao;

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
