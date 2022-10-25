package com.example.capstone.bbbr.dtos;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Business> favoriteListings;

    public UserDto(User user){
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
        if (user.getPassword()!=null)this.password = user.getPassword();
        if (user.getFavoriteListings()!=null)this.favoriteListings = user.getFavoriteListings();
    }
}
