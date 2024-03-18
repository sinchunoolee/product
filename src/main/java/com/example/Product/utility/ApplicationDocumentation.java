package com.example.Product.utility;

import com.example.Product.Model.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation {
    Contact contact() {
        return new Contact().name("Sinchana")
                .url("sinchana.in")
                .email("snooleesinchana@gmail.com");
    }

    Info info() {
        return new Info().title("Product Management System")
                .description("Restful API with basic crud operation")
                .version("v1")
                .contact(contact());
    }

    @Bean
    OpenAPI openAPI() {

        return new OpenAPI().info(info());
    }
}
