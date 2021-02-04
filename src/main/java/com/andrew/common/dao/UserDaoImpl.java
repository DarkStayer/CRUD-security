package com.andrew.common.dao;

import com.andrew.common.model.Role;
import com.andrew.common.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl extends AbsUsDAO implements UserDAO {

    @Override
    public void addUser(User user) {
        if (user.getId()==0){
            user.setRoles(new HashSet<>(Collections.singleton(new Role(1L, "ROLE_USER"))));
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

    public User loadUserByName(String name) {
        try {
            User user = entityManager.createQuery("SELECT u FROM User u where u.name = :name", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }
}

