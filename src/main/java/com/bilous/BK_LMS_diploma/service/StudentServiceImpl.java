package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.model.StudentDao;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;

import java.time.LocalDate;

public class StudentServiceImpl  implements StudentService{

    private StudentDao studentDao;

    private UserDao userDao;

    public StudentServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public StudentServiceImpl(){}

    @Override
    public Student createStudent(String firstName, String lastName, LocalDate dateOfBirth, Group group) {
        return new Student(firstName, lastName, dateOfBirth, group);
    }

    @Override
    public Student createStudentWithoutGroup(String firstName, String lastName, LocalDate dateOfBirth, String login, String password) {
        Student student = new Student(firstName, lastName, dateOfBirth);
        student.setLogin(login);
        student.setPassword(password);
        studentDao.saveStudent(student);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
}
