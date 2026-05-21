package com.example.springruling.rules.s5876;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S5876 - True Positive: Session fixation protection disabled with none().
 *
 * Calling sessionFixation().none() disables session fixation protection entirely,
 * meaning the session ID is not changed after authentication. An attacker who
 * knows a pre-authentication session ID can hijack the authenticated session.
 * SonarJava should flag this.
 */
@Configuration
public class S5876_TP {

    @Bean
    public SecurityFilterChain s5876TpFilterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session
                .sessionFixation(fixation -> fixation.none()) // Noncompliant - session fixation disabled
            )
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
