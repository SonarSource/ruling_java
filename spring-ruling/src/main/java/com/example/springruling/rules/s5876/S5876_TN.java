package com.example.springruling.rules.s5876;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S5876 - True Negative: Session fixation protection with migrateSession().
 *
 * Calling sessionFixation().migrateSession() creates a new session upon
 * authentication and copies the existing session attributes to the new session.
 * This is the default and recommended strategy. SonarJava should NOT flag this.
 */
@Configuration
public class S5876_TN {

    @Bean
    public SecurityFilterChain s5876TnFilterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session
                .sessionFixation(fixation -> fixation.migrateSession()) // Compliant - session migrated
            )
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
