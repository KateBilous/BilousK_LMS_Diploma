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
        return new ArrayList<>(Storage.getInstance().getLessons().values());
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        int newId = Storage.getInstance().getNewLessonId();
        lesson.setId(newId);
        return  Storage.getInstance().getLessons().put(lesson.getId(), lesson);
    }


    @Override
    public Lesson getLessonById(int id) {
        return Storage.getInstance().getLessons().get(id);

    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        int id = lesson.getId();
        Map<Integer, Lesson> lessons = Storage.getInstance().getLessons();
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateLessonById(Lesson lesson) {
        int id = lesson.getId();
        Map<Integer, Lesson> lessons = Storage.getInstance().getLessons();
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteLessonById(int id) {
        Map<Integer, Lesson> lessons = Storage.getInstance().getLesson();
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return true;
        }
        return false;
    }
}
