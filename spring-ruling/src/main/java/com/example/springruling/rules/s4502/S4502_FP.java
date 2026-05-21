package com.example.springruling.rules.s4502;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4502 - False Positive: CSRF disabled for a stateless REST API.
 *
 * For a purely stateless REST API that uses JWT tokens (no session cookies),
 * CSRF protection is not needed because there is no session to hijack.
 * Disabling CSRF here is a legitimate and widely-accepted practice, but the
 * analyzer will still flag it because it sees csrf.disable().
 */
@Configuration
public class S4502_FP {

    @Bean
    public SecurityFilterChain s4502FpFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Legitimate for stateless REST API - but still flagged
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").authenticated()
                .anyRequest().denyAll()
            );
        return http.build();
    }
}
