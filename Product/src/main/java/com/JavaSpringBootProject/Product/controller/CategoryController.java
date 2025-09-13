package com.JavaSpringBootProject.Product.controller;

import com.JavaSpringBootProject.Product.dto.CategoryDTO;
import com.JavaSpringBootProject.Product.entity.Category;
import com.JavaSpringBootProject.Product.exception.CategoryAlreadyExistsException;
import com.JavaSpringBootProject.Product.mapper.CategoryMapper;
import com.JavaSpringBootProject.Product.repository.CategoryRepository;
import com.JavaSpringBootProject.Product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Category REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operation for category REST API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private  CategoryService categoryService;

    private CategoryRepository categoryRepository;



    @Operation(
            summary = "Create category ",
            description = "REST API to create category "
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Fetch all category",
            description = "REST API to fetch all category "
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);

    }

    @Operation(
            summary = "Fetch category by category id",
            description = "REST API to fetch category by category id "
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return  new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "delete category by category id ",
            description = "REST API to delete category by category id "
    )
    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable Long id){
     return categoryService.deleteCategoryById(id);

    }



}
