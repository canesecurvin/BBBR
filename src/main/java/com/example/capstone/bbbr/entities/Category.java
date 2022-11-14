package com.example.capstone.bbbr.entities;

import com.example.capstone.bbbr.requests.CategoryRequest;
import com.example.capstone.bbbr.responses.CategoryResponse;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "categoryId")
    private List<Business> businesses;

    public Category(CategoryRequest categoryRequest){
        this.categoryName = categoryRequest.getCategoryName();
    }

    public Category(CategoryResponse categoryResponse){
        this.id = categoryResponse.getId();
        this.categoryName = categoryResponse.getCategoryName();
    }
}
