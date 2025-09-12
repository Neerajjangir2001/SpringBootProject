package com.JavaSpringBootProject.Product.service;

import com.JavaSpringBootProject.Product.dto.CategoryDTO;
import com.JavaSpringBootProject.Product.entity.Category;
import com.JavaSpringBootProject.Product.mapper.CategoryMapper;
import com.JavaSpringBootProject.Product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category categoryEntity = CategoryMapper.toCategoryEntity(categoryDTO);
         categoryEntity = categoryRepository.save(categoryEntity);
        return CategoryMapper.toCategoryDTO(categoryEntity);

    }




}
