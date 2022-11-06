package com.example.capstone.bbbr.requests;

import com.example.capstone.bbbr.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> roles;

    public RegisterUserRequest(User user){
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
    }
    @Override
    public String toString(){
        return getEmail() + ' ' + getLastName();
    }
}
