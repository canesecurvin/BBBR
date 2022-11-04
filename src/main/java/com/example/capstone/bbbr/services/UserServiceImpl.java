package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
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
    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        User user = new User(registerUserRequest);
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        userRepository.saveAndFlush(user);
        return new UserResponse(user);
    }
    @Override
    public UserResponse userLogin(LoginUserRequest loginUserRequest) {
        UserResponse userResponse = new UserResponse(loginUserRequest);
        Optional<User> userOptional = userRepository.findByEmail(loginUserRequest.getEmail());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(loginUserRequest.getPassword(), userOptional.get().getPassword())) {
                userResponse.setId(userOptional.get().getId());
                userResponse.setLastName(userOptional.get().getLastName());
                userResponse.setFirstName(userOptional.get().getFirstName());
            }
        }
        return userResponse;
    }

    @Override
    public String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return "Successfully deleted";
    }

    @Override
    public UserResponse updateUser(RegisterUserRequest registerUserRequest, Long userId){
        User user = new User(registerUserRequest);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            user.setPassword(userOptional.get().getPassword());
            user.setId(userId);
            userRepository.saveAndFlush(user);
        }
        return new UserResponse(user);
    }
}
