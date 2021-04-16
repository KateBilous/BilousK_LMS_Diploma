package com.bilous.BK_LMS_diploma.dao.model;


import com.bilous.BK_LMS_diploma.dao.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAll();

    Lesson saveLesson(Lesson lesson);

    Lesson getLessonById(int id);


    boolean updateLessonById(Lesson lesson, int id);

    boolean deleteLessonById(int id);
}
