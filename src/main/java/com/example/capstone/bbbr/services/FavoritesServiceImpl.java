package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.BusinessRepository;
import com.example.capstone.bbbr.repositories.FavoritesRepository;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.FavoritesRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.responses.FavoritesResponse;
import com.example.capstone.bbbr.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BusinessRepository businessRepository;

    @Override
    public List<FavoritesResponse> userFavorites(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Favorites> favorites = favoritesRepository.findAllByUser(userOptional.get());
            return favorites.stream().map(fav -> {
                UserResponse user = new UserResponse(userOptional.get());
                BusinessResponse business = new BusinessResponse(businessRepository.findById(fav.getBusinessId()).get());
//                System.out.println(business);
                FavoritesResponse favorite = new FavoritesResponse(fav.getId(), user,business);
//                System.out.println(favorite);
                return new FavoritesResponse(fav.getId(), user, business);
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<FavoritesResponse> addUserFavorite(FavoritesRequest favoritesRequest){
        Optional<User> userOptional = userRepository.findById(favoritesRequest.getUserId());
        if (userOptional.isPresent()){
            Favorites favorite = new Favorites(userOptional.get(), favoritesRequest.getBusinessId());
            favoritesRepository.saveAndFlush(favorite);
        }
        return this.userFavorites(favoritesRequest.getUserId());
    }

    @Override
    public List<FavoritesResponse> deleteUserFavorite(Long favoriteId, Long userId){
        favoritesRepository.deleteById(favoriteId);
        return this.userFavorites(userId);
    }

    @Override
    public String deleteAll(){
        favoritesRepository.deleteAll();
        return "ALL DELETED!";
    }
}
