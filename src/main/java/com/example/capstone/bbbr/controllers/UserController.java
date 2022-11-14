package com.example.capstone.bbbr.controllers;

import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.responses.UserResponse;
import com.example.capstone.bbbr.services.BusinessService;
import com.example.capstone.bbbr.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BusinessService businessService;

    @QueryMapping
    public UserResponse userLogin(@Argument("user") LoginUserRequest loginUserRequest){
        return userService.userLogin(loginUserRequest);
    }
<<<<<<< Updated upstream

    @QueryMapping
=======
    @PreAuthorize("hasRole('ROLE_GENERAL')")
    @MutationMapping
>>>>>>> Stashed changes
    public String deleteUser(@Argument("userId") Long userId){
        return userService.deleteUser(userId);
    }

    @MutationMapping
    public UserResponse newUser(@Argument("user") RegisterUserRequest registerUserRequest){
        return userService.registerUser(registerUserRequest);
    }

    @MutationMapping
    public UserResponse updateUser(@Argument("user") RegisterUserRequest registerUserRequest, @Argument("userId") Long userId){
        return userService.updateUser(registerUserRequest, userId);
    }

//    @SchemaMapping(typeName="UserResponse", field="favorites")
//    public List<BusinessResponse> favorites(Long userId){
//        return businessService.getAllBusinessesByUserId(userId);
//    }
}
