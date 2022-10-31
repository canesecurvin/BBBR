package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import lombok.Data;
import java.util.List;

@Data
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private List<Business> businesses;

    public CategoryResponse(Category category){
        if (category.getId()!=null)this.id = category.getId();
        if (category.getCategoryName()!=null)this.categoryName = category.getCategoryName();
        if (category.getBusinesses()!=null)this.businesses = category.getBusinesses();
    }
}
