package com.bilous.BK_LMS_diploma.domain.model;


import com.bilous.BK_LMS_diploma.domain.Student;

import java.util.List;

public interface StudentDao  {

    List<Student> getAll();

    Student saveStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean updateStudentById(Student student);

    boolean deleteStudentById(int id);
}
