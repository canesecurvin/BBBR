package com.example.capstone.bbbr.responses;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import com.example.capstone.bbbr.requests.CategoryRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private List<BusinessResponse> businesses;

    public CategoryResponse(Category category){
        if (category.getId()!=null)this.id = category.getId();
        if (category.getCategoryName()!=null)this.categoryName = category.getCategoryName();
    }
}
