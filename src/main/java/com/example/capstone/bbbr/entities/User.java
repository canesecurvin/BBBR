package com.example.capstone.bbbr.entities;

import com.example.capstone.bbbr.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany
    @Column(name = "business_id")
    private List<Business> favoriteListings;

    public User(UserDto userDto){
        if (userDto.getId()!=null)this.id = userDto.getId();
        if (userDto.getFirstName()!=null)this.firstName = userDto.getFirstName();
        if (userDto.getLastName()!=null)this.lastName = userDto.getLastName();
        if (userDto.getEmail()!=null)this.email = userDto.getEmail();
        if (userDto.getPassword()!=null)this.password = userDto.getPassword();
        if (userDto.getFavoriteListings()!=null)this.favoriteListings = userDto.getFavoriteListings();
    }
}
