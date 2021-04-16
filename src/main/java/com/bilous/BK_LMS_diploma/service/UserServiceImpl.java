package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.User;
import com.bilous.BK_LMS_diploma.dao.model.UserDao;

import java.time.LocalDate;
import java.util.Date;

public class UserServiceImpl implements UserService {

    public final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(String firstName, String lastName, Date dateOfBirth) {
        return new User( firstName, lastName, dateOfBirth);
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }
}
