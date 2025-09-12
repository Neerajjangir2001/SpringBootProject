package com.JavaSpringBootProject.Product.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private  Long id;
    private String name;
    private List<ProductDTO> product;

}
