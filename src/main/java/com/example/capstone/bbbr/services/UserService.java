package com.example.capstone.bbbr.services;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.UserResponse;

public interface UserService {
    UserResponse registerUser(RegisterUserRequest registerUserRequest);

    UserResponse userLogin(LoginUserRequest loginUserRequest);

    String deleteUser(Long userId);

    UserResponse updateUser(RegisterUserRequest registerUserRequest, Long userId);
}
