package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.Teacher;

import java.time.LocalDate;

public interface GroupService {

    Group createGroup(String name, String direction, LocalDate startDate);

    void createLessonsStubs(Group group, int minimumAmount);

    boolean addStudent(Group group, Student student);

    boolean addTeacher(Group group, Teacher teacher);

    Group saveGroup(Group group);


}
