package com.example.capstone.bbbr.repositories;

import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(RoleEnum roleName);
}
