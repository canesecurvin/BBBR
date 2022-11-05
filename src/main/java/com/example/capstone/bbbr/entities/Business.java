package com.example.capstone.bbbr.entities;


import com.example.capstone.bbbr.requests.BusinessRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "business_name")
    private String businessName;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "location")
    private String location;
    @Column(name = "website")
    private String website;
    @Column(name = "description")
    private String description;
    @Column(name = "specialty")
    private String specialty;
    @Column(name = "credentials")
    private String credentials;

    @JoinColumn(name = "category_id")
    private Long categoryId;

    public Business(BusinessRequest business){
        if (business.getBusinessName()!=null)this.businessName = business.getBusinessName();
        if (business.getOwnerName()!=null)this.ownerName = business.getOwnerName();
        if (business.getLocation()!=null)this.location = business.getLocation();
        if (business.getDescription()!=null)this.description = business.getDescription();
        if (business.getSpecialty()!=null)this.specialty = business.getSpecialty();
        if (business.getCredentials()!=null)this.credentials = business.getCredentials();
        if (business.getWebsite()!=null)this.website = business.getWebsite();
        if (business.getCategoryId()!=null)this.categoryId = business.getCategoryId();
    }

}
