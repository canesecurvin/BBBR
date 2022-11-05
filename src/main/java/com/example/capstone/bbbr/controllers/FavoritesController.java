package com.example.capstone.bbbr.controllers;

import com.example.capstone.bbbr.requests.FavoritesRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.responses.FavoritesResponse;
import com.example.capstone.bbbr.services.FavoritesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class FavoritesController {
    @Autowired
    FavoritesService favoritesService;

    @QueryMapping
    public List<FavoritesResponse> userFavorites(@Argument("userId") Long userId){
        return favoritesService.userFavorites(userId);
    }

    @MutationMapping
    public List<FavoritesResponse> addUserFavorite(@Argument("favorite") FavoritesRequest favoritesRequest){
        return favoritesService.addUserFavorite(favoritesRequest);
    }
//
    @MutationMapping
    public List<FavoritesResponse> deleteUserFavorite(@Argument("favoriteId") Long favoriteId, @Argument("userId") Long userId){
        return favoritesService.deleteUserFavorite(favoriteId, userId);
    }

    @MutationMapping String deleteAll(){
        return favoritesService.deleteAll();
    }
}
