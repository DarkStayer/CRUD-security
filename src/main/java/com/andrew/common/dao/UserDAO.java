package com.andrew.common.dao;

import com.andrew.common.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void removeUserById(long id);

    List <User> getAllUsers();

    User getUserById(long id);

    User loadUserByName (String name);
}

