package com.example.crud_fiscal.domain.controller;

import com.example.crud_fiscal.domain.service.CategoryService;
import com.example.crud_fiscal.exception.ErrorException;
import com.example.crud_fiscal.persistence.dto.entities.CategoryDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveCategoryDto;
import com.example.crud_fiscal.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/fiscal"+"/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    //Create category
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    @ApiOperation(value = "Save entity")
    public Response<CategoryDto> createCategory(@RequestBody @Validated SaveCategoryDto saveCategoryDto) throws ErrorException {
        return new Response<>("Succes",String.valueOf(HttpStatus.OK),"ok",this.categoryService.saveCategory(saveCategoryDto));
    }

    //Update category by id
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/update/{categoryId}")
    @ApiOperation(value = "Update entity")
    public Response<CategoryDto> updateCategory(@RequestBody @Validated SaveCategoryDto saveCategoryDto, @PathVariable Integer categoryId) throws ErrorException{
        return new Response<>("Succes",String.valueOf(HttpStatus.OK),"ok", this.categoryService.updateCategoryById(categoryId,saveCategoryDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    @ApiOperation(value = "Get all categories")
    public Response<List<CategoryDto>> getListAllCategories() throws ErrorException{
        return new Response<>("Succes",String.valueOf(HttpStatus.OK),"ok",this.categoryService.listAllCategory());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{categoryId}")
    @ApiOperation(value = "Delete category by id")
    public Response<String> deleteCategoryById(@PathVariable Integer categoryId) throws ErrorException{
        return new Response<>("Succes",String.valueOf(HttpStatus.OK),"ok",this.categoryService.deleteCategoryById(categoryId));
    }
}
