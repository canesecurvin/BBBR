package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.UserRequest;
import com.example.capstone.bbbr.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRequest userRequest){
        User user = new User(userRequest);
        userRepository.saveAndFlush(user);
        return new UserResponse(user);
    }
    @Override
    public UserResponse userLogin(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        Optional<User> userOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userRequest.getPassword(), userOptional.get().getPassword())){
                userResponse = new UserResponse(userRequest);
            }
        }
        return userResponse;
    }

    @Override
    public String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return "Successfully deleted";
    }
}
