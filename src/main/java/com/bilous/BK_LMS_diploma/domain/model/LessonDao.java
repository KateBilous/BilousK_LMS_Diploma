package com.bilous.BK_LMS_diploma.domain.model;


import com.bilous.BK_LMS_diploma.domain.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAll();

    Lesson saveLesson(Lesson lesson);

    Lesson getLessonById(int id);

    boolean updateLesson(Lesson lesson);

    boolean updateLessonById(Lesson lesson);

    boolean deleteLessonById(int id);
}
