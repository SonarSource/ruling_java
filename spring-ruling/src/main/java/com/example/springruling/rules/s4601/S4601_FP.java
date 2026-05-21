package com.example.springruling.rules.s4601;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4601 - False Positive: Independent patterns that look overlapping but are not.
 *
 * The patterns "/api/v1/**" and "/api/v2/**" are independent and do not overlap,
 * so their ordering does not matter. However, a naive pattern-overlap check might
 * flag them because they share the "/api/" prefix. This is a false positive.
 */
@Configuration
public class S4601_FP {

    @Bean
    public SecurityFilterChain s4601FpFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/**").hasRole("USER")      // Independent patterns
                .requestMatchers("/api/v2/**").hasRole("ADMIN")     // No overlap with /api/v1/**
                .requestMatchers("/health").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
