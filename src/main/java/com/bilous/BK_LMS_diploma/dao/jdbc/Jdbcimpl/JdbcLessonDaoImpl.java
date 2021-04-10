package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.dao.Lesson;
import com.bilous.BK_LMS_diploma.dao.model.GroupDao;
import com.bilous.BK_LMS_diploma.dao.model.LessonDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcLessonDaoImpl implements LessonDao {

    //TODO connection JDBC instead Persistence


    @Override
    public List<Lesson> getAll() {
        return new ArrayList<>(Persistence.getInstance().getLessons().values());
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        int newId = Persistence.getInstance().getNewLessonId();
        lesson.setId(newId);
        return  Persistence.getInstance().getLessons().put(lesson.getId(), lesson);
    }


    @Override
    public Lesson getLessonById(int id) {
        return Persistence.getInstance().getLessons().get(id);

    }



    @Override
    public boolean updateLessonById(Lesson lesson, int id) {
        Map<Integer, Lesson> lessons = Persistence.getInstance().getLessons();
        if (lessons.containsKey(lesson.getId())) {
            lessons.put(lesson.getId(), lesson);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteLessonById(int id) {
        Map<Integer, Lesson> lessons = Persistence.getInstance().getLessons();
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return true;
        }
        return false;
    }
}
