package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.requests.UserRequest;
import com.example.capstone.bbbr.responses.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);

    UserResponse userLogin(UserRequest userRequest);

    String deleteUser(Long userId);
}
