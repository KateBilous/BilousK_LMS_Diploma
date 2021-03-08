package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Lesson;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.Teacher;
import com.bilous.BK_LMS_diploma.domain.model.GroupDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService{

    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group createGroup(String name, String direction, LocalDate startDate) {
        return new Group(name, direction, startDate);
    }

    @Override
    public void createLessonsStubs(Group group, int minimumAmount) {
        List<Lesson> lessons =  new ArrayList<>();
        for (int i = 0; i < minimumAmount; i++) {
            lessons.add(new Lesson(group,"smth", "smth"));
            
        }
        group.getLessons().addAll(lessons);
    }

    @Override
    public boolean addStudent(Group group, Student student) {
        return group.getStudents().add(student);
    }

    @Override
    public boolean addTeacher(Group group, Teacher teacher) {
        teacher.addGroup(group);
        return group.getTeachers().add(teacher) ;
    }

    @Override
    public Integer saveGroup(Group group) {
        if(!validateGroup(group)){
            return -1;
            //TODO write log
        }
       return  groupDao.saveGroup(group);

    }

    private boolean validateGroup(Group group) {
        if(group.getStudents().size()< 12) return false;
        if (group.getTeachers().size()<1) return false;
        if(group.getLessons().size()<32) return false;
        if(group.getFeed() == null) return false;
        return true;
    }
}
