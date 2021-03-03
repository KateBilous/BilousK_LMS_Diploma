package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Teacher;
import com.bilous.BK_LMS_diploma.domain.User;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserDaoImpl  implements UserDao {

    @Override
    public List<User> getAll() {
        return new ArrayList<>(Storage.getUser().values());
    }

    @Override
    public User saveUser(User user) {
        User savedUser = createUserFromTemplate(user);
        int newId = Storage.getNewUserId();
        savedUser.setId(newId);
        Storage.getUser().put(newId, savedUser);
        return savedUser;
    }

    private User createUserFromTemplate(User user) {
        User newUser = new User(user.getFirstName(), user.getLastName(),user.getDateOfBirth());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setDateOfBirth(user.getDateOfBirth());
        return newUser;
    }

    @Override
    public User getUserById(int id) {
        Storage.getUser().get(id);
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        int id = user.getId();
       Map<Integer, User> users =Storage.getUser();
        if(users.containsKey(id)){
            users.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserById(User user) {
        int id = user.getId();
        Map<Integer, User> users = Storage.getUser();
        if (users.containsKey(id)) {
            users.put(id, user);
            return true;
        }
        return false;

    }


    @Override
    public boolean deleteUserById(int id) {
        Map<Integer, User> users = Storage.getUser();
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
}
