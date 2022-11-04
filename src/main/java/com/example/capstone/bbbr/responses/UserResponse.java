package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Favorites> favorites;

    public UserResponse(User user){
        if (user.getId()!=null)this.id = user.getId();
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
        this.favorites = new ArrayList<>();
    }

    public UserResponse(RegisterUserRequest user){
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
    }


    public UserResponse(LoginUserRequest user){
        if (user.getEmail()!=null)this.email = user.getEmail();
    }

    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getEmail() + " " + this.getLastName();
    }
}
