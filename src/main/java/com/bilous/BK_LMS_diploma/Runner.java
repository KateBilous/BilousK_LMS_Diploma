package com.bilous.BK_LMS_diploma;

import com.bilous.BK_LMS_diploma.domain.*;
import com.bilous.BK_LMS_diploma.domain.model.*;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.*;
import com.bilous.BK_LMS_diploma.persistence.Persistence;
import com.bilous.BK_LMS_diploma.service.*;

import java.time.LocalDate;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Persistence persistence = Persistence.getInstance();

        GroupDao groupDao = new InMemoryGroupDaoImpl();
        UserDao userDao = new InMemoryUserDaoImpl();
        TeacherDao teacherDao = new InMemoryTeacherDaoImpl();
        FeedDao feedDao = new InMemoryFeedDaoImpl();
        HomeTaskDao homeTaskDao = new InMemoryHomeTask();
        LessonDao lessonDao = new InMemoryLessonDaoImpl();
        PostDao postDao= new InMemoryPostDaoImpl();



        GroupService groupService = new GroupServiceImpl(groupDao);
        UserService userService = new UserServiceImpl(userDao);
        HomeTaskService homeTaskService= new HomeTaskServiceImpl(homeTaskDao);
        LessonService lessonService = new LessonServiceImpl(lessonDao);
        PostService postService = new PostServiceImpl(postDao);
        FeedService feedService = new FeedServiceImpl(feedDao);
        Group group = new Group("Java", "Back-end", LocalDate.now());
        groupService.createGroup("Java Enterprise", "Back-end", LocalDate.of(2021, 3, 7));
        Post post = new Post(feedDao.getFeedById(1),"Ola la", LocalDate.now(), "Blink");
        groupService.createGroup("Java Basic", "Back-end", LocalDate.of(2021, 3, 7));
       // userService.createUser("Olha","Klimko", LocalDate.of(1992, 2,2));
        lessonService.createLesson(group, "smth","smth");
        postService.createPost(feedService.creteFeed(group), "smth", LocalDate.now(), "Arthur");
        postService.savePost(post);




        Group group1 = new Group("Java", "Back-end", LocalDate.now());
        Group group2 = new Group("JavaBasic", "Back-end", LocalDate.now());
        Group group3 = new Group("JavaEnterprise", "Back-end", LocalDate.now());
        User user1 = new User("Kate", "Bilos", LocalDate.of(1991, 12, 07));
        Teacher teacher1 = new Teacher("Mike", "Nedosekin", LocalDate.of(1988, 8, 21),
                "teacher");
        createTeachers(group, groupService);


        groupDao.saveGroup(group1);
        groupDao.saveGroup(group2);
        groupDao.saveGroup(group3);
        userDao.saveUser(user1);
        teacherDao.saveTeacher(teacher1);


        group2.setId(2);
        user1.setId(1);
        group2.setName("Java BASIC");
        user1.setLastName("Bean");
        teacher1.setFirstName("Bob");

        groupDao.updateGroupById(group2, 1);
        userDao.updateUserById(user1, 1);

        groupDao.deleteGroupById(1);

        List<Group> groups = groupDao.getAll();
        List<Teacher> teachers = teacherDao.getAll();

        Group fromDb = groupDao.getGroupById(3);

        groupDao.updateGroupById(group1,1);


        Student student = new Student("Kate", "Bilous", LocalDate.ofYearDay(1991, 5),
                group1);
        Feed feed = new Feed(group1);
        Lesson lesson = new Lesson(group1, "smth", "kdkdkd");
        HomeTask homeTask = new HomeTask(lesson, 87, LocalDate.now(), "jsjsjsj", LocalDate.of(2021,
                9, 8));
        HomeWork homeWork = new HomeWork(homeTask, 85, "redone", "Martha");

        groupDao.saveGroup(group1);
        feedDao.saveFeed(feed);



    }

    private static void createTeachers(Group group, GroupService groupService) {
        Teacher teacher = new Teacher("Igor", "Volodin", LocalDate.of(1988, 4, 9),
                "teacher");
        Teacher mentor = new Teacher("Taras", "Lipka", LocalDate.of(1990, 3, 4),
                "mentor");
        groupService.addTeacher(group, teacher);
        groupService.addTeacher(group, mentor);

    }
}
