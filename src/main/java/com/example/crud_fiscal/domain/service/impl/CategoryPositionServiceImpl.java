package com.example.crud_fiscal.domain.service.impl;

import com.example.crud_fiscal.domain.entities.Category;
import com.example.crud_fiscal.domain.repository.CategoryRepository;
import com.example.crud_fiscal.domain.service.CategoryService;
import com.example.crud_fiscal.exception.InternalServerErrorException;
import com.example.crud_fiscal.exception.NotFoundException;
import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveCategoryDto;
import com.example.crud_fiscal.exception.ErrorException;
import com.example.crud_fiscal.persistence.mapper.SuperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryPositionServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final SuperMapper<Category,CategoryDto> categoryMapper;

    @Autowired
    public CategoryPositionServiceImpl(CategoryRepository categoryRepository, SuperMapper<Category, CategoryDto> categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto saveCategory(SaveCategoryDto createCategory) throws ErrorException {
        Category category = new Category();
        category.setName(createCategory.getName());
        try {
            this.categoryRepository.save(category);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE_ENTITY");
        }
        return this.categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto updateCategoryById(Integer idCategory, SaveCategoryDto saveCategoryDto) throws ErrorException {
        Category category = this.categoryRepository.findById(idCategory).orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_CATEGORY_NOT_FOUND"));
        category.setName(saveCategoryDto.getName());
        try {
            this.categoryRepository.save(category);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE_ENTITY");
        }
        return this.categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> listAllCategory() throws ErrorException {
        List<Category> listCategories = this.categoryRepository.findAll();
        return this.categoryMapper.toDtoList(listCategories);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) throws ErrorException {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_CATEGORY_NOT_FOUND"));
        return this.categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto getCategoryByName(String nameCategory) throws ErrorException {
        Category category;
        try {
            category = this.categoryRepository.findByName(nameCategory);
        }catch (final Exception e){
            throw new NotFoundException("SNOT-404-1","ID_CATEGORY_NOT_FOUND");
        }
        return this.categoryMapper.toDto(category);
    }

    @Override
    public String deleteCategoryById(Integer categoryId) throws ErrorException {
        try {
            this.categoryRepository.deleteById(categoryId);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","DELETE");
        }

        return "ENTITY_DELETED";
    }
}
