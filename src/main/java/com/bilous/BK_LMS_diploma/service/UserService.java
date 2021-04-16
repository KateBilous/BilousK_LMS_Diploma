package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.User;

import java.time.LocalDate;
import java.util.Date;

public interface UserService {

    User createUser(String firstName, String lastName, Date dateOfBirth);

    User saveUser(User user);


    
}
