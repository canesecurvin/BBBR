package com.example.capstone.bbbr.requests;

import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
