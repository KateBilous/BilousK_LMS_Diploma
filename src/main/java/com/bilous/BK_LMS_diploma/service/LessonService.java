package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Lesson;

public interface LessonService {

    Lesson createLesson(Group group, String topic, String materials);

    Lesson saveLesson(Lesson lesson);
}
