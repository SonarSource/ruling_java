package com.example.springruling.rules.s4502;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * S4502 - False Negative: CSRF disabled via a helper method.
 *
 * The actual csrf.disable() call is wrapped inside a helper method, making it
 * harder for the analyzer to detect. The analyzer might not trace the
 * Customizer lambda through the helper and could miss this CSRF disablement.
 */
@Configuration
public class S4502_FN {

    @Bean
    public SecurityFilterChain s4502FnFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(this::applyCsrfPolicy) // CSRF disabled via indirection - analyzer may miss
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }

    /**
     * Helper method that disables CSRF. The analyzer may not follow the
     * method reference to detect that CSRF is actually being disabled.
     */
    private void applyCsrfPolicy(CsrfConfigurer<HttpSecurity> csrf) {
        csrf.disable();
    }
}
