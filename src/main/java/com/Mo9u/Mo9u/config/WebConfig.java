package com.Mo9u.Mo9u.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "http://27.96.135.10:3000")
                .allowedHeaders("Content-Type", "X-AUTH-TOKEN", "Authorization", "Bearer")
                .allowedMethods(HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.DELETE.name(), HttpMethod.PUT.name(), HttpMethod.PATCH.name(), HttpMethod.OPTIONS.name())
                .allowCredentials(false)
                .exposedHeaders("Authorization", "X-AUTH-TOKEN", "Bearer")
                .maxAge(3000);
    }
}
