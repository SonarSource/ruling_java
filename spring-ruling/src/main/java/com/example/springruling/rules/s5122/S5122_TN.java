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
 * S5122 - True Negative: CORS policy restricted to a trusted origin.
 *
 * The @CrossOrigin annotation and CorsConfiguration both specify a specific
 * trusted origin, restricting cross-origin access appropriately.
 * SonarJava should NOT flag this.
 */
@CrossOrigin(origins = "https://trusted.example.com") // Compliant - specific origin
@RestController
@Configuration
public class S5122_TN {

    @GetMapping("/s5122/tn/data")
    public String getData() {
        return "sensitive data";
    }

    @Bean
    public CorsConfigurationSource s5122TnCorsSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("https://trusted.example.com"); // Compliant - specific origin
        config.addAllowedMethod("GET");
        config.addAllowedHeader("Authorization");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);
        return source;
    }
}
