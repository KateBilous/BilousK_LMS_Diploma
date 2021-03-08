package com.bilous.BK_LMS_diploma;

import com.bilous.BK_LMS_diploma.domain.*;
import com.bilous.BK_LMS_diploma.domain.model.FeedDao;
import com.bilous.BK_LMS_diploma.domain.model.GroupDao;
import com.bilous.BK_LMS_diploma.domain.model.TeacherDao;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryFeedDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryGroupDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryTeacherDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryUserDaoImpl;

import java.time.LocalDate;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        GroupDao groupDao = new InMemoryGroupDaoImpl();
        UserDao userDao = new InMemoryUserDaoImpl();
        TeacherDao teacherDao = new InMemoryTeacherDaoImpl();
        FeedDao feedDao = new InMemoryFeedDaoImpl();


        Group group1 = new Group("Java", "Back-end", LocalDate.now());
        Group group2 = new Group("JavaBasic", "Back-end", LocalDate.now());
        Group group3 = new Group("JavaEnterprise", "Back-end", LocalDate.now());
        User user1 =new User("Kate", "Bilos", LocalDate.of(1991,12,07));
        Teacher teacher = new Teacher("Mike","Nedosekin", LocalDate.of(1988,8,21),
                "teacher");


        groupDao.saveGroup(group1);
        groupDao.saveGroup(group2);
        groupDao.saveGroup(group3);
        userDao.saveUser(user1);
        teacherDao.saveTeacher(teacher);


        group2.setId(2);
        user1.setId(1);
        group2.setName("Java BASIC");
        user1.setLastName("Bean");
        teacher.setFirstName("Bob");

        groupDao.updateGroupById(group2, 1);
        userDao.updateUserById(user1, 1);

        groupDao.deleteGroupById(1);

        List<Group> groups = groupDao.getAll();
        List<Teacher> teachers= teacherDao.getAll();

        Group fromDb = groupDao.getGroupById(3);

        groupDao.updateGroupById(group1,1);


        Student student = new Student("Kate", "Bilous", LocalDate.ofYearDay(1991, 5),
                group1);
        Feed feed = new Feed(group1);
        Post post = new Post(feed, "Sone text", LocalDate.now(), "Olha");
        Lesson lesson = new Lesson(group1, "smth", "kdkdkd");
        HomeTask homeTask = new HomeTask(lesson, 87, LocalDate.now(), "jsjsjsj", LocalDate.of(2021,
                9, 8));
        HomeWork homeWork = new HomeWork(homeTask, 85, "redone", "Martha");

        groupDao.saveGroup(group1);
        feedDao.saveFeed(feed);






    }
}
