package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.requests.FavoritesRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.responses.FavoritesResponse;

import java.util.List;

public interface FavoritesService {
    List<FavoritesResponse> userFavorites(Long userId);

    List<FavoritesResponse> addUserFavorite(FavoritesRequest favoritesRequest);

    List<FavoritesResponse> deleteUserFavorite(Long favoriteId, Long userId);

    String deleteAll();
}
