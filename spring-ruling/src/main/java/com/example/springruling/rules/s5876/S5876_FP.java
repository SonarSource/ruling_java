package com.example.springruling.rules.s5876;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S5876 - False Positive: sessionFixation().none() for a stateless JWT API.
 *
 * For a purely stateless API using JWT tokens, there are no server-side sessions.
 * Session fixation is not a concern because SessionCreationPolicy.STATELESS
 * ensures no sessions are ever created. Calling sessionFixation().none() is
 * redundant but harmless. The analyzer may still flag it.
 */
@Configuration
public class S5876_FP {

    @Bean
    public SecurityFilterChain s5876FpFilterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions created
                .sessionFixation(fixation -> fixation.none()) // Harmless with STATELESS - analyzer may flag
            )
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
