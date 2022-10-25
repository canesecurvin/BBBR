package com.example.capstone.bbbr.entities;

import com.example.capstone.bbbr.dtos.BusinessDto;
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
    @ManyToOne
    @Column(name = "category_id")
    private Category categoryId;

    public Business(BusinessDto businessDto){
        if (businessDto.getId()!=null)this.id = businessDto.getId();
        if (businessDto.getBusinessName()!=null)this.businessName = businessDto.getBusinessName();
        if (businessDto.getOwnerName()!=null)this.ownerName = businessDto.getOwnerName();
        if (businessDto.getLocation()!=null)this.location = businessDto.getLocation();
        if (businessDto.getDescription()!=null)this.description = businessDto.getDescription();
        if (businessDto.getSpecialty()!=null)this.specialty = businessDto.getSpecialty();
        if (businessDto.getCredentials()!=null)this.credentials = businessDto.getCredentials();
        if (businessDto.getCategoryId()!=null)this.categoryId = businessDto.getCategoryId();
    }
}
