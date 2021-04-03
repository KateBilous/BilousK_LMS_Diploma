package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import com.bilous.BK_LMS_diploma.domain.HomeWork;

public interface HomeWorkService {

    HomeWork createHomework (HomeTask homeTasks, int score, String resolution, String author);

    HomeWork saveHomework(HomeWork homeWork);
}
