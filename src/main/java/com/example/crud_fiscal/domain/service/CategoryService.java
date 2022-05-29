package com.example.crud_fiscal.domain.service;

import com.example.crud_fiscal.domain.entities.Category;
import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveCategoryDto;
import com.example.crud_fiscal.exception.ErrorException;

import java.util.List;

public interface CategoryService {
    CategoryDto saveCategory(SaveCategoryDto createCategory) throws ErrorException;
    CategoryDto updateCategoryById(Integer categoryId, SaveCategoryDto saveCategoryDto) throws ErrorException;
    List<CategoryDto> listAllCategory() throws ErrorException;
    CategoryDto getCategoryById(Integer categoryId) throws ErrorException;

    CategoryDto getCategoryByName(String nameCategory) throws ErrorException;
    String deleteCategoryById(Integer categoryId) throws ErrorException;

}
