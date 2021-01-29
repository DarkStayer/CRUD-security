package com.andrew.common.dao;

import com.andrew.common.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl extends AbsUsDAO implements UserDAO {

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        User removeUser = entityManager.find(User.class, id);
        entityManager.remove(removeUser);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        User editUser = entityManager.find(User.class, user.getId());
        editUser.setAge(user.getAge());
        editUser.setName(user.getName());
        editUser.setLastName(user.getLastName());
        entityManager.merge(editUser);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List <User> getAllUsers() {
        return entityManager
                .createNamedQuery("User.getAll", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}

