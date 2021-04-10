package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.Student;

import java.time.LocalDate;

public interface StudentService {

    Student createStudent(String firstName, String lastName, LocalDate dateOfBirth, Group group);

    Student saveStudent(Student student);


}
