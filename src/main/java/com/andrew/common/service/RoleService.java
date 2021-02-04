package com.andrew.common.service;

import com.andrew.common.model.Role;
import com.andrew.common.model.User;

import java.util.HashSet;
import java.util.Set;

public interface RoleService {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
    public Set<Role> getAllRoles ();
}
