package com.example.capstone.bbbr.repositories;

import com.example.capstone.bbbr.entities.Favorites;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.responses.FavoritesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    List<Favorites> findAllByUser(User user);
}
