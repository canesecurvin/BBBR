package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import lombok.Data;

@Data
public class BusinessResponse {
    private Long id;
    private String businessName;
    private String ownerName;
    private String location;
    private String website;
    private String description;
    private String specialty;
    private String credentials;
    private Category category;

    public BusinessResponse(Business business){
        if (business.getId()!=null)this.id = business.getId();
        if (business.getBusinessName()!=null)this.businessName = business.getBusinessName();
        if (business.getOwnerName()!=null)this.ownerName = business.getOwnerName();
        if (business.getLocation()!=null)this.location = business.getLocation();
        if (business.getDescription()!=null)this.description = business.getDescription();
        if (business.getSpecialty()!=null)this.specialty = business.getSpecialty();
        if (business.getCredentials()!=null)this.credentials = business.getCredentials();
        if (business.getCategory()!=null)this.category = business.getCategory();
    }
}