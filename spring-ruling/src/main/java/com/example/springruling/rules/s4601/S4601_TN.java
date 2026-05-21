package com.example.springruling.rules.s4601;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4601 - True Negative: URL patterns in correct order (most specific first).
 *
 * The most specific pattern "/admin/settings" is listed before the broader
 * "/admin/**", so the more restrictive rule is evaluated first. This is the
 * correct ordering. SonarJava should NOT flag this.
 */
@Configuration
public class S4601_TN {

    @Bean
    public SecurityFilterChain s4601TnFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/settings").hasRole("SUPERADMIN") // Compliant - most specific first
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
