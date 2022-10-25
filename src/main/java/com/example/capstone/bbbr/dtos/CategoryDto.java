package com.example.capstone.bbbr.dtos;

import com.example.capstone.bbbr.entities.Business;
import com.example.capstone.bbbr.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;
    private String categoryName;
    private List<Business> businessIds;

    public CategoryDto(Category category){
        if (category.getId()!=null)this.id = category.getId();
        if (category.getCategoryName()!=null)this.categoryName = category.getCategoryName();
        if (category.getBusinessIds()!=null)this.businessIds = category.getBusinessIds();
    }
}
