package com.example.capstone.bbbr.requests;

import lombok.Data;

@Data
public class BusinessRequest {
    private String businessName;
    private String ownerName;
    private String description;
    private String location;
    private String website;
    private String number;
    private String credentials;
    private Long categoryId;
}
