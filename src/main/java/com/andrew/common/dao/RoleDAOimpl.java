package com.andrew.common.dao;

import com.andrew.common.model.Role;
import com.andrew.common.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDAOimpl extends AbsUsDAO implements RoleDAO {

    public RoleDAOimpl() {
    }

    @Override
    public void save(Role role) {
        Role managed = entityManager.merge(role);
        entityManager.persist(managed);
    }

    @Override
    public void delete(Role role) {
        Role managed = entityManager.merge(role);
        entityManager.remove(managed);
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String rolename) {
        return entityManager.createQuery("SELECT r FROM Role r where r.name = :name", Role.class)
                .setParameter("name", rolename)
                .getSingleResult();
    }

    @Override
    public Set<Role> getAllRoles() {
        Set <Role> roles = new HashSet<>();
        Role roleAdmin = new Role (2L,"ROLE_ADMIN");
        Role roleUser = new Role (1L,"ROLE_USER");
        roles.add(roleAdmin);
        roles.add(roleUser);
        return roles;
    }
}
