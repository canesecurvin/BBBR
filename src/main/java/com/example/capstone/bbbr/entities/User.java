package com.example.capstone.bbbr.entities;

import com.example.capstone.bbbr.requests.RegisterUserRequest;

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
    @OneToMany(mappedBy = "user")
    private List<Favorites> favorites;

    public User(RegisterUserRequest user){
        if (user.getFirstName()!=null)this.firstName = user.getFirstName();
        if (user.getLastName()!=null)this.lastName = user.getLastName();
        if (user.getEmail()!=null)this.email = user.getEmail();
        if (user.getPassword()!=null)this.password = user.getPassword();
    }
}
