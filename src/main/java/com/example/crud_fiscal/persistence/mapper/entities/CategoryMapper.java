package com.example.crud_fiscal.persistence.mapper.entities;

import com.example.crud_fiscal.domain.entities.Category;
import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.mapper.SuperMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper implements SuperMapper<Category, CategoryDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto toDto(Category category) {
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        return this.modelMapper.map(categoryDto,Category.class);
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> list) {
        return list.stream().map(category -> this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
    }
}
