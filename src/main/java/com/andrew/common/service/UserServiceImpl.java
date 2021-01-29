package com.andrew.common.service;

import com.andrew.common.dao.UserDAO;
import com.andrew.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public List <User>getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
