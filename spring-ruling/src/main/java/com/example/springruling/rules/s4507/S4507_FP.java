package com.example.springruling.rules.s4507;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4507 - False Positive: debug=true on a test/dev configuration class.
 *
 * This configuration is annotated with @Profile("test"), indicating it should
 * only be active in test environments. Debug mode is intentionally enabled
 * for troubleshooting in non-production environments. However, since the file
 * lives in src/main, the analyzer will still flag it as a production debug issue.
 */
@Profile("test")
@Configuration
@EnableWebSecurity(debug = true) // Intentional for test profile - analyzer flags anyway
public class S4507_FP {

    @Bean
    public SecurityFilterChain s4507FpFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );
        return http.build();
    }
}
