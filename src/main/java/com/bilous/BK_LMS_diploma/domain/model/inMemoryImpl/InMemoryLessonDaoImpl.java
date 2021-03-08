package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Lesson;
import com.bilous.BK_LMS_diploma.domain.model.LessonDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryLessonDaoImpl implements LessonDao {


    @Override
    public List<Lesson> getAll() {
        return new ArrayList<>(Storage.getLessons().values());
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        int newId = Storage.getNewLessonId();
        lesson.setId(newId);
        return  Storage.getLessons().put(lesson.getId(), lesson);
    }


    @Override
    public Lesson getLessonById(int id) {
        return Storage.getLessons().get(id);

    }

    @Override
    public boolean updateLessonById(Lesson lesson, int id) {
        Map<Integer, Lesson> lessons = Storage.getLessons();
        if (lessons.containsKey(lesson.getId())) {
            lessons.put(lesson.getId(), lesson);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteLessonById(int id) {
        Map<Integer, Lesson> lessons = Storage.getLessons();
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return true;
        }
        return false;
    }
}
