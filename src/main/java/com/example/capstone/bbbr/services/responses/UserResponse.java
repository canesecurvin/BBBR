package com.example.capstone.bbbr.services.responses;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import lombok.Data;

import java.util.List;
@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Favorites> favorites;

    public UserResponse(User user){
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
        if (user.getFavorites()!=null)this.favorites = user.getFavorites();
    }
}
