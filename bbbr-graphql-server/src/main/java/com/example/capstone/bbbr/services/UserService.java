package com.example.capstone.bbbr.services;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.UserResponse;

import java.text.ParseException;

public interface UserService {
    UserResponse registerUser(RegisterUserRequest registerUserRequest);

    UserResponse userLogin(LoginUserRequest loginUserRequest) throws ParseException;

    String deleteUser(Long userId);

    UserResponse updateUser(RegisterUserRequest registerUserRequest, Long userId);
}
