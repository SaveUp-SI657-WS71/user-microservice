package com.upc.saveup.user_microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("http://localhost:4200")     //(Aqui colocan la url de su frontend desplegada)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("http://localhost:4200")
                        .allowCredentials(true);
    }
}