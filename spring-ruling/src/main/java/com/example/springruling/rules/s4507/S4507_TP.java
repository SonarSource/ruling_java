package com.example.springruling.rules.s4507;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4507 - True Positive: Debug mode enabled in @EnableWebSecurity and WebSecurityCustomizer.
 *
 * Setting debug = true in @EnableWebSecurity causes Spring Security to log
 * sensitive information including request details, headers, and security
 * filter chain decisions. Using WebSecurity.debug(true) has the same effect.
 * This should never be enabled in production.
 * SonarJava should flag this.
 */
@Configuration
@EnableWebSecurity(debug = true) // Noncompliant - debug features activated via annotation
public class S4507_TP {

    @Bean
    public SecurityFilterChain s4507TpFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.debug(true); // Noncompliant - debug features activated via method call
    }
}
