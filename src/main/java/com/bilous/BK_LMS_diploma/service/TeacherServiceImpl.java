package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Teacher;
import com.bilous.BK_LMS_diploma.dao.model.TeacherDao;

import java.time.LocalDate;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher createTeacher(String firstName, String lastName, LocalDate dateOfBirth, String role) {
        return new Teacher(firstName,lastName, dateOfBirth, role);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }
}
