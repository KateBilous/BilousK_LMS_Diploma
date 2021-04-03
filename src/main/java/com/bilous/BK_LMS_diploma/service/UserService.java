package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.User;

import java.util.Optional;

public interface UserService {

    //User createUser(String firstName, String lastName, LocalDate dateOfBirth);

    User createUser(User user, String login, String password);

    User saveUser(User user);

    Optional<Object> getByLogin(String login);


    
}
