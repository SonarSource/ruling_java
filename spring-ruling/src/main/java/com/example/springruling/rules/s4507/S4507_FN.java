package com.example.springruling.rules.s4507;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4507 - False Negative: Debug enabled only via application.properties.
 *
 * This configuration class has @EnableWebSecurity without debug=true in the
 * annotation. However, the application.properties file could contain:
 *   spring.security.debug=true
 * which would enable debug at runtime. The static analyzer cannot detect
 * property-based debug activation.
 *
 * Note: the actual property would be in application.properties, not in this file.
 * This class is compliant from a static analysis perspective but could still
 * have debug enabled at runtime.
 */
@Configuration
@EnableWebSecurity // Looks compliant, but debug could be enabled via application.properties
public class S4507_FN {

    // Simulating the scenario where debug is toggled externally.
    // The analyzer sees debug=false (default) and does not flag it.

    @Bean
    public SecurityFilterChain s4507FnFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
