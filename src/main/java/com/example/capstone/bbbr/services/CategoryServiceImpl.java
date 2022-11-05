package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.entities.Category;
import com.example.capstone.bbbr.repositories.BusinessRepository;
import com.example.capstone.bbbr.repositories.CategoryRepository;
import com.example.capstone.bbbr.requests.CategoryRequest;
import com.example.capstone.bbbr.responses.BusinessResponse;
import com.example.capstone.bbbr.responses.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BusinessRepository businessRepository;
    @Override
    public List<CategoryResponse> addCategory(CategoryRequest categoryRequest){
        Category category = new Category(categoryRequest);
        categoryRepository.saveAndFlush(category);
        return getAllCategories();
    }

    @Override
    public List<CategoryResponse> deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
        return getAllCategories();
    }
    @Override
    public List<CategoryResponse> getAllCategories(){
        List<Category> cats = categoryRepository.findAll();

        return cats.stream().map(cat -> getCategoryById(cat.getId())).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategoryById(Long categoryId){
        CategoryResponse categoryResponse = new CategoryResponse();
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()){
            categoryResponse = new CategoryResponse(categoryOptional.get());
            List<BusinessResponse> businesses = businessRepository.findBusinessesByCategoryId(categoryId);
            categoryResponse.setBusinesses(businesses);
        }
        return categoryResponse;
    }
}
