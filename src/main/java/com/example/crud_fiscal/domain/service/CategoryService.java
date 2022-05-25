package com.example.crud_fiscal.domain.service;

import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveCategoryDto;
import com.example.crud_fiscal.persistence.dto.error.ErrorException;

import java.util.List;

public interface CategoryService {
    CategoryDto saveCategory(SaveCategoryDto createCategory) throws ErrorException;
    CategoryDto updateCategoryById(Integer idCategory, SaveCategoryDto saveCategoryDto) throws ErrorException;
    List<CategoryDto> listAllCategory() throws ErrorException;
    CategoryDto getCategoryById(Integer categoryId) throws ErrorException;
    String deleteCategoryById(Integer categoryId) throws ErrorException;

}