package com.andrew.common.dao;

import com.andrew.common.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl extends AbsUsDAO implements UserDAO {

    @Override
    public void addUser(User user) {
        if(user.getId()==0) {
            entityManager.persist(user);
        }
        else {
            entityManager.merge(user);
        }
    }

    @Override
    public void removeUserById(long id) {
        User removeUser = entityManager.find(User.class, id);
        entityManager.remove(removeUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List <User> getAllUsers() {
        return entityManager
                .createNativeQuery("SELECT * from users.users", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}

