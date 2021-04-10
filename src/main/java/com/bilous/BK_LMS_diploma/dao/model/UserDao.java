package com.bilous.BK_LMS_diploma.dao.model;


import com.bilous.BK_LMS_diploma.dao.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User saveUser(User user);

    User getUserById(int id);

    boolean updateUserById(User user, int id);

    boolean deleteUserById(int id);

}
