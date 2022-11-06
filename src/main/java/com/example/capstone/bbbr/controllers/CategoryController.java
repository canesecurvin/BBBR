package com.example.capstone.bbbr.controllers;

import com.example.capstone.bbbr.requests.CategoryRequest;
import com.example.capstone.bbbr.responses.CategoryResponse;
import com.example.capstone.bbbr.services.CategoryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
@PreAuthorize("hasRole('USER_ADMIN')")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @QueryMapping
    public CategoryResponse category(@Argument("id") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @MutationMapping
    public List<CategoryResponse> newCategory(@Argument("category") CategoryRequest categoryRequest){
        return categoryService.addCategory(categoryRequest);
    }

    @MutationMapping
    public List<CategoryResponse> deleteCategory(@Argument("id") Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @QueryMapping
    public List<CategoryResponse> categories(){
        return categoryService.getAllCategories();
    }
}
