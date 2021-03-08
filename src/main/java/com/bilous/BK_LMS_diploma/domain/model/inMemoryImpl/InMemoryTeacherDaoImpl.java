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
        return new ArrayList<>(Storage.getInstance().getTeacher().values());
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        Teacher savedTeacher = buildTeacherFromTemplate(teacher);
        int newId = Storage.getInstance().getNewTeacherId();
        savedTeacher.setId(newId);
        Storage.getInstance().getTeacher().put(newId, savedTeacher);
        return savedTeacher;
    }

    private Teacher buildTeacherFromTemplate(Teacher teacher) {
        Teacher newTeacher = new Teacher(teacher.getFirstName(), teacher.getLastName(), teacher.getDateOfBirth(),
                teacher.getRole());
        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getLastName());
        newTeacher.setDateOfBirth(teacher.getDateOfBirth());
        newTeacher.setRole(teacher.getRole());
        return newTeacher;
    }

    @Override
    public Teacher getTeacherById(int id) {
        return Storage.getInstance().getTeacher().get(id);

    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        int id = teacher.getId();
        Map<Integer, Teacher> teachers = Storage.getInstance().getTeacher();
        if (teachers.containsKey(id)) {
            teachers.put(id, teacher);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateTeacherById(Teacher teacher) {
        int id = teacher.getId();
        Map<Integer, Teacher> teachers = Storage.getInstance().getTeacher();
        if (teachers.containsKey(id)) {
            teachers.put(id, teacher);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteTeacherById(int id) {
        Map<Integer, Teacher> teachers = Storage.getInstance().getTeacher();
        if (teachers.containsKey(id)) {
            teachers.remove(id);
            return true;
        }
        return false;
    }
}
