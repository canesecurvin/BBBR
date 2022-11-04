package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import lombok.Data;

@Data
public class FavoritesResponse {
    private User user;
    private Long businessId;

    public FavoritesResponse(Favorites favorites){
        if (favorites.getUser()!=null)this.user = favorites.getUser();
        if (favorites.getBusinessId()!=null)this.businessId = favorites.getBusinessId();
    }
}
