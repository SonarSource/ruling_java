package com.example.springruling.rules.s4502;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4502 - True Positive: CSRF protection explicitly disabled.
 *
 * The SecurityFilterChain calls csrf.disable() in multiple patterns.
 * This leaves the application vulnerable to cross-site request forgery attacks.
 * SonarJava should flag the disable() call on the CsrfConfigurer.
 * Note: S4502 is a Security Hotspot, so it may appear under hotspots, not issues.
 */
@Configuration
public class S4502_TP {

    @Bean
    public SecurityFilterChain s4502TpFilterChainLambda(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Noncompliant - CSRF protection disabled via lambda
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public SecurityFilterChain s4502TpFilterChainMethodRef(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Noncompliant - CSRF protection disabled via method reference
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
