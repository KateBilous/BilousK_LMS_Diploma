package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.model.StudentDao;

import java.time.LocalDate;

public class StudentServiceImpl  implements StudentService{

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student createStudent(String firstName, String lastName, LocalDate dateOfBirth, Group group) {
        return new Student(firstName, lastName, dateOfBirth, group);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
}
