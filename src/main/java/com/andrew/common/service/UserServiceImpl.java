package com.andrew.common.service;

import com.andrew.common.dao.UserDAO;
import com.andrew.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    @Transactional
    public List <User>getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.loadUserByName(s);
    }
}
