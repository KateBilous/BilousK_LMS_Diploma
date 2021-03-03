package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAll();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    boolean updateTeacher(Teacher teacher);

    boolean updateTeacherById(Teacher teacher);

    boolean deleteTeacherById(int id);
}
