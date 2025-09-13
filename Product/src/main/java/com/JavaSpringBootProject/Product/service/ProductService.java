package com.JavaSpringBootProject.Product.service;

import com.JavaSpringBootProject.Product.dto.ProductDTO;
import com.JavaSpringBootProject.Product.entity.Category;
import com.JavaSpringBootProject.Product.entity.Product;
import com.JavaSpringBootProject.Product.exception.CategoryNotFoundException;
import com.JavaSpringBootProject.Product.mapper.ProductMapper;
import com.JavaSpringBootProject.Product.repository.CategoryRepository;
import com.JavaSpringBootProject.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductService {


    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO crateProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId()).
                orElseThrow(() -> new CategoryNotFoundException(" Category " + productDTO.getCategoryId() + " not found "));

        Product productEntity = ProductMapper.toProductEntity(productDTO, category);

        productEntity = productRepository.save(productEntity);
        return ProductMapper.toProductDTO(productEntity);

    }

    public List<ProductDTO> getAllProduct(){

      return  productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();

    }


    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
            return ProductMapper.toProductDTO(product);

    }

    public String deleteProductById(Long id){
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found!"));


              product.setName(productDTO.getName());
              product.setDescription(productDTO.getDescription());
              product.setPrice(productDTO.getPrice());
              product.setCategory(category );

        product = productRepository.save(product);

      return ProductMapper.toProductDTO(product);

    }
}
