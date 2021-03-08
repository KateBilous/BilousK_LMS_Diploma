package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.User;
import com.bilous.BK_LMS_diploma.domain.model.UserDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryUserDaoImpl  implements UserDao {

    @Override
    public List<User> getAll() {
        return new ArrayList<>(Persistence.getInstance().getUsers().values());
    }

    @Override
    public User saveUser(User user) {
        int newId = Persistence.getInstance().getNewUserId();
        user.setId(newId);
        return Persistence.getInstance().getUsers().put(user.getId(), user);
    }


    @Override
    public User getUserById(int id) {
        Persistence.getInstance().getUsers().get(id);
        return null;
    }

    @Override
    public boolean updateUserById(User user, int id) {
        Map<Integer, User> users = Persistence.getInstance().getUsers();
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return true;
        }
        return false;

    }


    @Override
    public boolean deleteUserById(int id) {
        Map<Integer, User> users = Persistence.getInstance().getUsers();
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
}
