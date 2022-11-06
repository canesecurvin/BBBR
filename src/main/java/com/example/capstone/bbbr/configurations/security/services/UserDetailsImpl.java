package com.example.capstone.bbbr.configurations.security.services;

import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
public class UserDetailsImpl implements UserDetails {
    @Autowired
    static
    RoleService roleService;
    @Autowired
    private static UserRepository userRepository;
    private Long id;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(RegisterUserRequest user) {
        Set<String> roleSet = new HashSet<>();
        user.getRoles().forEach(role-> {
            roleSet.add(role);
        });
        List<GrantedAuthority> authorities = roleService.getUserRoleSet(roleSet).stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                userRepository.findByEmail(user.getEmail()).get().getId(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
