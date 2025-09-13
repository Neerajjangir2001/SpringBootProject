package com.JavaSpringBootProject.Product.service;

import com.JavaSpringBootProject.Product.dto.CategoryDTO;
import com.JavaSpringBootProject.Product.entity.Category;
import com.JavaSpringBootProject.Product.exception.CategoryAlreadyExistsException;
import com.JavaSpringBootProject.Product.mapper.CategoryMapper;
import com.JavaSpringBootProject.Product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Optional<Category> byName = categoryRepository.findByName(categoryDTO.getName());

        if (byName.isPresent()) {
            throw new CategoryAlreadyExistsException("Category " + categoryDTO.getName() + " already exists");
        }
        Category categoryEntity = CategoryMapper.toCategoryEntity(categoryDTO);
         categoryEntity = categoryRepository.save(categoryEntity);
        return CategoryMapper.toCategoryDTO(categoryEntity);

    }


    public List<CategoryDTO> getAllCategory(){
      return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
  }

  public CategoryDTO getCategoryById(Long id){
      Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
       return CategoryMapper.toCategoryDTO(category);
  }

  public String  deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        return "Category deleted successfully";
  }



}
