package com.andrew.common.service;

import com.andrew.common.dao.RoleDAO;
import com.andrew.common.model.Role;
import com.andrew.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDAO roleDAO;

    @Override
    @Transactional
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDAO.delete(role);
    }

    @Override
    @Transactional
    public Role getById(Long id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public Role getRoleByName(String rolename) {
        return roleDAO.getRoleByName(rolename);
    }

    @Override
    public Set<Role> getAllRoles (){
        return roleDAO.getAllRoles();
    }
}
