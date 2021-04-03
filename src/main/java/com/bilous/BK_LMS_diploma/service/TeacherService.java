package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.Teacher;

import java.time.LocalDate;

public interface TeacherService {

    Teacher createTeacher(String firstName, String lastName, LocalDate dateOfBirth,
                                      String login, String password);

    Teacher saveTeacher(Teacher teacher);
}
