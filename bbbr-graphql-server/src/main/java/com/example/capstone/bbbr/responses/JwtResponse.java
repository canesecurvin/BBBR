package com.example.capstone.bbbr.responses;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String jwtToken;
    private String tokenType = "Bearer";
    private Long id;
    private String username;
    private List<String> roles;

    public JwtResponse(String token, UserResponse userResponse, List<String> roles) {
        this.jwtToken = token;
        this.id = userResponse.getId();
        this.username = userResponse.getEmail();
        this.roles = roles;
    }
}
