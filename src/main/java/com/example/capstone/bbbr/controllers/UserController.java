package com.example.capstone.bbbr.controllers;

import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.UserResponse;
import com.example.capstone.bbbr.services.BusinessService;
import com.example.capstone.bbbr.services.RoleService;
import com.example.capstone.bbbr.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.text.ParseException;

@Controller
@AllArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BusinessService businessService;

    @Autowired
    RoleService roleService;

    @QueryMapping
    public UserResponse userLogin(@Argument("user") LoginUserRequest loginUserRequest) throws ParseException {
        UserResponse u = userService.userLogin(loginUserRequest);
        System.out.println("---------CONTROLLER"+u.getJwtResponse().toString());
        return u;
    }
    @PreAuthorize("hasRole('ROLE_GENERAL')")
    @QueryMapping
    public String deleteUser(@Argument("userId") Long userId){
        return userService.deleteUser(userId);
    }

    @MutationMapping
    public UserResponse newUser(@Argument("user") RegisterUserRequest registerUserRequest){
        UserResponse user = userService.registerUser(registerUserRequest);
        if (user.getErrorMessage()!=null){
            UserResponse ur = new UserResponse();
            ur.setErrorMessage(user.getErrorMessage());
            return ur;
        } else return user;
    }
    @PreAuthorize("hasRole('ROLE_GENERAL')")
    @MutationMapping
    public UserResponse updateUser(@Argument("user") RegisterUserRequest registerUserRequest, @Argument("userId") Long userId){
        return userService.updateUser(registerUserRequest, userId);
    }

    @MutationMapping
    public String addRole(@Argument("role") RoleEnum roleEnum){
        System.out.println(roleEnum);
        roleService.addRole(roleEnum);
        return "added";
    }
}
