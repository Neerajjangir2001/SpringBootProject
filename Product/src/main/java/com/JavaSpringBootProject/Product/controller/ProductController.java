package com.JavaSpringBootProject.Product.controller;


import com.JavaSpringBootProject.Product.dto.ProductDTO;
import com.JavaSpringBootProject.Product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operation for product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {



    private ProductService productService;

    @Operation(
            summary = "Fetch all product",
            description = "REST API to fetch all product "
    )
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }


    @Operation(
            summary = "Create  product ",
            description = "REST API to create product "
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize(("hasAuthority('ROLE_SELLER')"))
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.crateProduct(productDTO), HttpStatus.CREATED);
    }


    @Operation(
            summary = "update Product ",
            description = "REST API to update product by product id "
    )
    @PreAuthorize(("hasAuthority('ROLE_SELLER')"))
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
      return  new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }


    @Operation(
            summary = "delete Product by product id ",
            description = "REST API to delete product by product id "
    )
    @PreAuthorize(("hasAuthority('ROLE_SELLER')"))
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }


    @Operation(
            summary = "Fetch product by product id",
            description = "REST API to fetch product by product id "
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);

    }


}
