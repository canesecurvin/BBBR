package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.RoleEnum;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<RoleEnum> getUserRoleSet(Set<String> strRoles);

    void addRole(RoleEnum roleEnum);

    void deleteAll();
}
