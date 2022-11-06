package com.example.capstone.bbbr.configurations.security.services;

import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);
        User user = new User();
        if (userOptional.isPresent()){
            user = userOptional.get();
        }
        return UserDetailsImpl.build(new RegisterUserRequest(user));
    }
}
