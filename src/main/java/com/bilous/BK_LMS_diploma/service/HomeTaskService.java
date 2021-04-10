package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.HomeTask;
import com.bilous.BK_LMS_diploma.dao.Lesson;

import java.time.LocalDate;

public interface HomeTaskService {

    HomeTask createHomeTask(Lesson lesson, int task, LocalDate date, String materials, LocalDate deadline);

    HomeTask saveHomeTask(HomeTask homeTask);
}
