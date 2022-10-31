package com.example.capstone.bbbr.entities;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
