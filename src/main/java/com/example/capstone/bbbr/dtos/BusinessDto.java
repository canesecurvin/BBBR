package com.example.capstone.bbbr.dtos;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessDto {
    private Long id;
    private String businessName;
    private String ownerName;
    private String location;
    private String website;
    private String description;
    private String specialty;
    private String credentials;
    private Category categoryId;

    public BusinessDto(Business business){
        if (business.getId()!=null)this.id = business.getId();
        if (business.getBusinessName()!=null)this.businessName = business.getBusinessName();
        if (business.getOwnerName()!=null)this.ownerName = business.getOwnerName();
        if (business.getLocation()!=null)this.location = business.getLocation();
        if (business.getDescription()!=null)this.description = business.getDescription();
        if (business.getSpecialty()!=null)this.specialty = business.getSpecialty();
        if (business.getCredentials()!=null)this.credentials = business.getCredentials();
        if (business.getCategoryId()!=null)this.categoryId = business.getCategoryId();
    }
}
