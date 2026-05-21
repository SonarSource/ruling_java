package com.example.springruling.rules.s4601;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4601 - False Negative: URL patterns built dynamically from variables.
 *
 * The patterns are constructed at runtime from string variables, so the static
 * analyzer cannot determine the actual pattern values or their ordering.
 * In this example, the patterns are effectively "/admin/**" before "/admin/settings",
 * which is incorrect, but the analyzer cannot detect it.
 */
@Configuration
public class S4601_FN {

    private static final String BASE_PATH = "/admin";
    private static final String WILDCARD = "/**";
    private static final String SETTINGS = "/settings";

    @Bean
    public SecurityFilterChain s4601FnFilterChain(HttpSecurity http) throws Exception {
        String broadPattern = BASE_PATH + WILDCARD;       // Resolves to "/admin/**"
        String specificPattern = BASE_PATH + SETTINGS;    // Resolves to "/admin/settings"

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(broadPattern).hasRole("ADMIN")         // Wrong order - but uses variables
                .requestMatchers(specificPattern).hasRole("SUPERADMIN") // Shadowed - analyzer can't detect
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
