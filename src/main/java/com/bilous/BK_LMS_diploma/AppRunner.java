package com.bilous.BK_LMS_diploma;

import com.bilous.BK_LMS_diploma.domain.model.FeedDao;
import com.bilous.BK_LMS_diploma.domain.model.GroupDao;
import com.bilous.BK_LMS_diploma.domain.model.LessonDao;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryFeedDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryGroupDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryLessonDaoImpl;
import com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl.InMemoryUserDaoImpl;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import com.bilous.BK_LMS_diploma.presentation.views.StartView;
import com.bilous.BK_LMS_diploma.presentation.views.StartViewDispatcher;
import com.bilous.BK_LMS_diploma.service.StudentServiceImpl;
import com.bilous.BK_LMS_diploma.service.UserService;
import com.bilous.BK_LMS_diploma.service.UserServiceImpl;
import com.mysql.cj.Session;
import org.apache.log4j.BasicConfigurator;

public class AppRunner {

    public static Session currentSession;

    public static void main(String[] args) throws Exception {
        RunningScripts.run();

        GroupDao groupDao = new InMemoryGroupDaoImpl();
        UserDao userDao = new InMemoryUserDaoImpl();
        LessonDao lessonDao = new InMemoryLessonDaoImpl();
        FeedDao feedDao = new InMemoryFeedDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl(userDao);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        BasicConfigurator.configure();

        StartView app = new StartView(userService);
        app.run();
    }
}
