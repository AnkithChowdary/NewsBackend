package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")  // allows all origins (use allowedOriginPatterns instead of allowedOrigins)
                        .allowedMethods("*")         // allows all HTTP methods
                        .allowedHeaders("*")         // allows all headers
                        .allowCredentials(true);     // allows cookies/auth headers
            }
        };
    }
}
