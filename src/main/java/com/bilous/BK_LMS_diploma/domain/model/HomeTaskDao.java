package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.HomeTask;
import java.util.List;

public interface HomeTaskDao {

    List<HomeTask> getAll();

    HomeTask saveHomeTask(HomeTask lesson);

    HomeTask getHomeTaskById(int id);

    boolean updateHomeTaskById(HomeTask homeTask, int id);

    boolean deleteHomeTaskById(int id);
}
