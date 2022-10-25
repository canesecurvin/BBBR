package com.example.capstone.bbbr.entities;

import com.example.capstone.bbbr.dtos.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;
    @OneToMany
    @Column(name = "business_id")
    private List<Business> businessIds;

    public Category(CategoryDto categoryDto){
        if (categoryDto.getId()!=null)this.id = categoryDto.getId();
        if (categoryDto.getCategoryName()!=null)this.categoryName = categoryDto.getCategoryName();
        if (categoryDto.getBusinessIds()!=null)this.businessIds = categoryDto.getBusinessIds();
    }
}
