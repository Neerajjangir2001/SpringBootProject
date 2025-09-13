package com.JavaSpringBootProject.Product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Schema(
        name = "Category",
        description = "It holds category information along with their product "
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private  Long id;
    private String name;
    private List<ProductDTO> product;

}
