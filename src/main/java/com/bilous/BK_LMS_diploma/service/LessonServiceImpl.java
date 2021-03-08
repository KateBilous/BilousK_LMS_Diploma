package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Lesson;
import com.bilous.BK_LMS_diploma.domain.model.LessonDao;

public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public Lesson createLesson(Group group, String topic, String materials) {
        return new Lesson(group,topic, materials);

    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return lessonDao.saveLesson(lesson);
    }
}
