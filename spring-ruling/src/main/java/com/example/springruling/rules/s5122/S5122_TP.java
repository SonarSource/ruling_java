package com.example.springruling.rules.s5122;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * S5122 - True Positive: CORS policy allows all origins.
 *
 * This class demonstrates two violations:
 * 1. @CrossOrigin(origins = "*") on the controller allows any origin.
 * 2. CorsConfiguration.addAllowedOrigin("*") in the bean allows any origin.
 * Both configurations are overly permissive and should be flagged by SonarJava.
 */
@CrossOrigin(origins = "*") // Noncompliant - allows all origins
@RestController
@Configuration
public class S5122_TP {

    @GetMapping("/s5122/tp/data")
    public String getData() {
        return "sensitive data";
    }

    @Bean
    public CorsConfigurationSource s5122TpCorsSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Noncompliant - allows all origins
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
