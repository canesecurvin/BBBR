package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Favorites> favorites;

    private Set<RoleEnum> roles = new HashSet<>();

    private JwtResponse jwtResponse;

    private String errorMessage;

    public UserResponse(User user){
        if (user.getId()!=null)this.id = user.getId();
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
        this.favorites = new ArrayList<>();
    }

    public void setRoles(RoleEnum role) {
        this.roles.add(role);
    }

    public UserResponse(LoginUserRequest user){
        if (user.getEmail()!=null)this.email = user.getEmail();
    }

    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getEmail() + " " + this.getLastName();
    }
}
