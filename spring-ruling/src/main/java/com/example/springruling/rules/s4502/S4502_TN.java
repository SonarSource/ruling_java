package com.example.springruling.rules.s4502;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4502 - True Negative: CSRF protection kept at default (enabled).
 *
 * The SecurityFilterChain does not disable CSRF, so Spring Security's default
 * CSRF protection remains active. SonarJava should NOT flag this.
 */
@Configuration
public class S4502_TN {

    @Bean
    public SecurityFilterChain s4502TnFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth // Compliant - CSRF remains enabled by default
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
