package com.bilous.BK_LMS_diploma.domain.model;


import com.bilous.BK_LMS_diploma.domain.HomeWork;

import java.util.List;

public interface HomeworkDao {

    List<HomeWork> getAll();

    HomeWork saveHomeWork(HomeWork homeWork);

    HomeWork getHomeWorkById(int id);

    boolean updateHomeWorkById(HomeWork homeWork, int id);

    boolean deleteHomeWorkById(int id);
}
