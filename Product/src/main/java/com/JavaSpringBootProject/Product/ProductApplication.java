package com.JavaSpringBootProject.Product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Product Service REST API documentation",
                description = "Product service REST API",
                version = "v2",
                contact = @Contact(
                        name = "Neeraj Jangir",
                        email = "neerajjangir2002@gmai.com"
                )
        )
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
