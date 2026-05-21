package com.example.springruling.rules.s5876;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * S5876 - False Negative: Session fixation disabled via custom SessionAuthenticationStrategy.
 *
 * This class uses a custom SessionAuthenticationStrategy that does nothing on
 * authentication (i.e., does not change the session ID). This effectively
 * disables session fixation protection, but the analyzer may not detect it
 * because it doesn't see sessionFixation().none() in the configuration.
 */
@Configuration
public class S5876_FN {

    @Bean
    public SecurityFilterChain s5876FnFilterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session
                .sessionAuthenticationStrategy(noOpSessionStrategy()) // Custom strategy - analyzer may miss
            )
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            );
        return http.build();
    }

    /**
     * Custom SessionAuthenticationStrategy that does NOT change the session ID.
     * This effectively disables session fixation protection, but bypasses
     * the pattern the analyzer looks for (sessionFixation().none()).
     */
    @Bean
    public SessionAuthenticationStrategy noOpSessionStrategy() {
        return new SessionAuthenticationStrategy() {
            @Override
            public void onAuthentication(Authentication authentication,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
                // Intentionally does nothing - session ID is not changed
                // This is equivalent to sessionFixation().none() but via custom strategy
            }
        };
    }
}
