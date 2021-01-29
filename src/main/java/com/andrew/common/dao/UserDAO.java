package com.andrew.common.dao;

import com.andrew.common.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void removeUserById(long id);

    List <User> getAllUsers();

    User getUserById(long id);
}

