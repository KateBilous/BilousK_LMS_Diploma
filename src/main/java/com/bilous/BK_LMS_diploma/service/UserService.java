package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.User;

import java.time.LocalDate;

public interface UserService {

    User createUser(String firstName, String lastName, LocalDate dateOfBirth);

    User saveUser(User user);


    
}
