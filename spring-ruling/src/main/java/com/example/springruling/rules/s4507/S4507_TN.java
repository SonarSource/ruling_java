package com.example.springruling.rules.s4507;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4507 - True Negative: @EnableWebSecurity without debug or with debug=false.
 *
 * The default value for debug is false, so omitting it or explicitly setting
 * it to false is compliant. SonarJava should NOT flag this.
 */
@Configuration
@EnableWebSecurity // Compliant - debug defaults to false
public class S4507_TN {

    @Bean
    public SecurityFilterChain s4507TnFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
