package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Teacher;

import java.time.LocalDate;

public interface TeacherService {

    Teacher createTeacher(String firstName, String lastName, LocalDate dateOfBirth, String role);

    Teacher saveTeacher(Teacher teacher);
}
