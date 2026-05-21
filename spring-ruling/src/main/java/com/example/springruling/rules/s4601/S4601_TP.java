package com.example.springruling.rules.s4601;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4601 - True Positive: URL patterns in wrong order (less specific before more specific).
 *
 * NOTE: The S4601 check (SpringAntMatcherOrderCheck) specifically requires
 * the deprecated antMatchers() API from Spring Security 5.x which was removed
 * in Spring Security 6.x (Spring Boot 3.x). The check matches:
 *   HttpSecurity.authorizeRequests() -> antMatchers(String...)
 * Since antMatchers() no longer exists in Spring Security 6.4+, this rule
 * CANNOT trigger in a Spring Boot 3.x project.
 *
 * This file uses the closest available API (authorizeHttpRequests + requestMatchers)
 * to demonstrate the intended anti-pattern. To make this rule trigger, the project
 * would need to use Spring Security 5.x (Spring Boot 2.x).
 */
@Configuration
@SuppressWarnings("deprecation")
public class S4601_TP {

    @Bean
    public SecurityFilterChain s4601TpFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/admin/settings").hasRole("SUPERADMIN") // Should be Noncompliant but can't trigger - antMatchers() removed
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
