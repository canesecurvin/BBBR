package com.example.capstone.bbbr.services.requests;

import lombok.Data;

@Data
public class FavoritesRequest {
    private Long userId;
    private Long businessId;
}
