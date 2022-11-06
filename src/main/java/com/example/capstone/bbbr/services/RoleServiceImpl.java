package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.RoleRepository;
import com.example.capstone.bbbr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addRole(RoleEnum roleEnum){
        Role role = new Role();
        role.setRoleName(roleEnum);
        System.out.println(role);
        roleRepository.saveAndFlush(role);
    }

    @Override
    public Set<RoleEnum> getUserRoleSet(Set<String> strRoles){
        Set<RoleEnum> roles = new HashSet<>();
        if (strRoles==null) {
            RoleEnum role = roleRepository.findRoleByRoleName(RoleEnum.USER_GENERAL).get().getRoleName();
            roles.add(role);
        }else {
            strRoles.forEach(str -> {
                switch (str) {
                    case "USER_ADMIN": {
                        RoleEnum role = roleRepository.findRoleByRoleName(RoleEnum.USER_ADMIN).get().getRoleName();
                        roles.add(role);
                        break;
                    }
                    case "USER_BUSINESS_OWNER": {
                        RoleEnum role = roleRepository.findRoleByRoleName(RoleEnum.USER_BUSINESS_OWNER).get().getRoleName();
                        roles.add(role);
                        break;
                    }
                    default: {
                        RoleEnum role = roleRepository.findRoleByRoleName(RoleEnum.USER_GENERAL).get().getRoleName();
                        roles.add(role);
                        break;
                    }
                }
            });
        }
        return roles;
    }

    @Override
    public void deleteAll(){
        roleRepository.deleteAll();
    }
}
