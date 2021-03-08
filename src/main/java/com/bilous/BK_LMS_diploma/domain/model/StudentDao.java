package com.bilous.BK_LMS_diploma.domain.model;


import com.bilous.BK_LMS_diploma.domain.Student;

import java.util.List;

public interface StudentDao  {

    List<Student> getAll();

    Student saveStudent(Student student);

    Student getStudentById(int id);


    boolean updateStudentById(Student student, int id);

    boolean deleteStudentById(int id);
}
