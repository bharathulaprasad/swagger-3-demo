package com.example.demo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class SpringdocConfig implements WebMvcConfigurer{

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Employee API")
                .version("1.0.0")
                .description("API for managing employees from Spring Doc"));
    }
}
