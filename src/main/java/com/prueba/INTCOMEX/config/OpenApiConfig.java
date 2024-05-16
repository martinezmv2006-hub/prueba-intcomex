package com.prueba.INTCOMEX.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "INTCOMEX CRUD",
                version = "1.0.0",
                description = "This is a CRUD for management INTCOMEX"
        )
)
public class OpenApiConfig implements WebMvcConfigurer {

}