package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAll();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(int id);


    boolean updateTeacherById(Teacher teacher, int id);

    boolean deleteTeacherById(int id);
}
