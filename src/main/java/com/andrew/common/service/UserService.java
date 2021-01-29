package com.andrew.common.service;

import com.andrew.common.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void removeUserById(long id);

    void editUser(User user);

    List <User> getAllUsers();

    User getUserById(long id);
}
