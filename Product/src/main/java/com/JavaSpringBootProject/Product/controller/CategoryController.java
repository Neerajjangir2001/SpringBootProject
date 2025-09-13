package com.JavaSpringBootProject.Product.controller;

import com.JavaSpringBootProject.Product.dto.CategoryDTO;
import com.JavaSpringBootProject.Product.entity.Category;
import com.JavaSpringBootProject.Product.exception.CategoryAlreadyExistsException;
import com.JavaSpringBootProject.Product.mapper.CategoryMapper;
import com.JavaSpringBootProject.Product.repository.CategoryRepository;
import com.JavaSpringBootProject.Product.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private  CategoryService categoryService;

    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return  new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable Long id){
     return categoryService.deleteCategoryById(id);

    }



}
