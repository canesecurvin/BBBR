package com.example.capstone.bbbr.requests;

import com.example.capstone.bbbr.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Override
    public String toString(){
        return getEmail() + ' ' + getLastName();
    }
}
