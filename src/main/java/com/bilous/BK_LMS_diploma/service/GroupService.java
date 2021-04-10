package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.Student;
import com.bilous.BK_LMS_diploma.dao.Teacher;

import java.time.LocalDate;

public interface GroupService {

    Group createGroup(String name, String direction, LocalDate startDate);

    void createLessonsStubs(Group group, int minimumAmount);

    boolean addStudent(Group group, Student student);

    boolean addTeacher(Group group, Teacher teacher);

    Group saveGroup(Group group);


}
