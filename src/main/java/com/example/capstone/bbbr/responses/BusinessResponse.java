package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessResponse {
    private Long id;
    private String businessName;
    private String ownerName;
    private String location;
    private String website;
    private String description;
    private String number;
    private String credentials;
    private Long categoryId;

    public BusinessResponse(Business business){
        if (business.getId()!=null)this.id = business.getId();
        if (business.getBusinessName()!=null)this.businessName = business.getBusinessName();
        if (business.getOwnerName()!=null)this.ownerName = business.getOwnerName();
        if (business.getLocation()!=null)this.location = business.getLocation();
        if (business.getDescription()!=null)this.description = business.getDescription();
        if (business.getNumber()!=null)this.number = business.getNumber();
        if (business.getWebsite()!=null)this.website = business.getWebsite();
        if (business.getCredentials()!=null)this.credentials = business.getCredentials();
        if (business.getCategoryId()!=null)this.categoryId = business.getCategoryId();
    }

    public BusinessResponse(BusinessResponse business){
        if (business.getId()!=null)this.id = business.getId();
        if (business.getBusinessName()!=null)this.businessName = business.getBusinessName();
        if (business.getOwnerName()!=null)this.ownerName = business.getOwnerName();
        if (business.getLocation()!=null)this.location = business.getLocation();
        if (business.getDescription()!=null)this.description = business.getDescription();
        if (business.getNumber()!=null)this.number = business.getNumber();
        if (business.getWebsite()!=null)this.website = business.getWebsite();
        if (business.getCredentials()!=null)this.credentials = business.getCredentials();
//        if (business.getCategory()!=null)this.category = business.getCategory();
    }
}
