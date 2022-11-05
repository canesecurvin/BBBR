package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.requests.CategoryRequest;
import com.example.capstone.bbbr.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> addCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> deleteCategory(Long categoryId);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(Long categoryId);
}
