package com.bilous.BK_LMS_diploma.domain.model;


import com.bilous.BK_LMS_diploma.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User saveUser(User user);

    User getUserById(int id);

    boolean updateUserById(User user, int id);

    boolean deleteUserById(int id);

}
