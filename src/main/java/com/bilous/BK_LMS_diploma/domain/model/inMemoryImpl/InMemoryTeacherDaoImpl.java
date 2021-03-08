package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Teacher;
import com.bilous.BK_LMS_diploma.domain.model.TeacherDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class InMemoryTeacherDaoImpl implements TeacherDao  {

    @Override
    public List<Teacher> getAll() {
        return new ArrayList<>(Storage.getTeachers().values());
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        int newId = Storage.getNewTeacherId();
        teacher.setId(newId);
        return Storage.getTeachers().put(teacher.getId(), teacher);
    }


    @Override
    public Teacher getTeacherById(int id) {
        return Storage.getTeachers().get(id);

    }


    @Override
    public boolean updateTeacherById(Teacher teacher, int id) {
        Map<Integer, Teacher> teachers = Storage.getTeachers();
        if (teachers.containsKey(teacher.getId())) {
            teachers.put(teacher.getId(), teacher);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteTeacherById(int id) {
        Map<Integer, Teacher> teachers = Storage.getTeachers();
        if (teachers.containsKey(id)) {
            teachers.remove(id);
            return true;
        }
        return false;
    }
}
