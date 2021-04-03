package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.User;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    public final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //@Override
   //public User createUser(String firstName, String lastName, LocalDate dateOfBirth)
   // { return new User( firstName, lastName, dateOfBirth);
   // }




    @Override
    public User createUser(User user, String login, String password) {
       user.setLogin(login);
       user.setPassword(password);
      // user.setId(userDao.saveUser(user));
        return user;
    }

    @Override
    public Optional<Object> getByLogin(String login) {
        return Optional.empty();
    }


    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }


}
