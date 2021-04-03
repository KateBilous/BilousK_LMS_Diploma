package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.Teacher;
import com.bilous.BK_LMS_diploma.domain.User;
import com.bilous.BK_LMS_diploma.domain.model.TeacherDao;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;

import java.time.LocalDate;

public class TeacherServiceImpl implements TeacherService  {

    private final TeacherDao teacherDao;





    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    @Override
    public Teacher createTeacher(String firstName, String lastName, LocalDate dateOfBirth, String login, String password) {
        Teacher teacher =new Teacher(firstName, lastName, dateOfBirth);
        teacher.setLogin(login);
        teacher.setPassword(password);
        teacherDao.saveTeacher(teacher);

        return teacher;
    }





    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }
}
