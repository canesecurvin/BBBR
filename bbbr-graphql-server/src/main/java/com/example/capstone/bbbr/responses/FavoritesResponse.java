package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.FavoritesRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoritesResponse {
    private Long id;
    private UserResponse user;
    private BusinessResponse business;

    public FavoritesResponse(Long id, UserResponse user, BusinessResponse business){
        this.id = id;
        if (user!=null)this.user = user;
        if (business!=null)this.business = business;
    }
}
