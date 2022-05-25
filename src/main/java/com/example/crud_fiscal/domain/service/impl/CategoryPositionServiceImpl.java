package com.example.crud_fiscal.domain.service.impl;

import com.example.crud_fiscal.domain.repository.CategoryRepository;
import com.example.crud_fiscal.domain.service.CategoryService;
import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveCategoryDto;
import com.example.crud_fiscal.persistence.dto.error.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryPositionServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryPositionServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto saveCategory(SaveCategoryDto createCategory) throws ErrorException {
        return null;
    }

    @Override
    public CategoryDto updateCategoryById(Integer idCategory, SaveCategoryDto saveCategoryDto) throws ErrorException {
        return null;
    }

    @Override
    public List<CategoryDto> listAllCategory() throws ErrorException {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) throws ErrorException {
        return null;
    }

    @Override
    public String deleteCategoryById(Integer categoryId) throws ErrorException {
        return null;
    }
}
