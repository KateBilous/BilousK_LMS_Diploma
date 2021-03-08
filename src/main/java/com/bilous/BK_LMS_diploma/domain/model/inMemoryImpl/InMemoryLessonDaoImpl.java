package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Lesson;
import com.bilous.BK_LMS_diploma.domain.model.LessonDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryLessonDaoImpl implements LessonDao {


    @Override
    public List<Lesson> getAll() {
        return new ArrayList<>(Persistence.getInstance().getLesson().values());
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        Lesson savedLesson = buildLessonFromTemplate(lesson);
        int newId = Persistence.getInstance().getNewLessonId();
        savedLesson.setId(newId);
        Persistence.getInstance().getLesson().put(newId, savedLesson);
        return savedLesson;
    }

    private Lesson buildLessonFromTemplate(Lesson lesson) {
        Lesson newLesson = new Lesson(lesson.getGroup(), lesson.getTopic(), lesson.getMaterials());
        newLesson.setGroup(lesson.getGroup());
        newLesson.setTopic(lesson.getTopic());
        newLesson.setMaterials(lesson.getMaterials());
        return newLesson;
    }

    @Override
    public Lesson getLessonById(int id) {
        return Persistence.getInstance().getLesson().get(id);

    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        int id = lesson.getId();
        Map<Integer, Lesson> lessons = Persistence.getInstance().getLesson();
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateLessonById(Lesson lesson) {
        int id = lesson.getId();
        Map<Integer, Lesson> lessons = Persistence.getInstance().getLesson();
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteLessonById(int id) {
        Map<Integer, Lesson> lessons = Persistence.getInstance().getLesson();
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return true;
        }
        return false;
    }
}
