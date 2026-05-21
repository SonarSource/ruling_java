package com.example.springruling.rules.s5804;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * S5804 - True Negative: DaoAuthenticationProvider with hideUserNotFoundExceptions.
 *
 * The DaoAuthenticationProvider is configured with setHideUserNotFoundExceptions(true),
 * which converts UsernameNotFoundException into a generic BadCredentialsException.
 * This prevents user enumeration. SonarJava should NOT flag this.
 */
@Configuration
public class S5804_TN {

    @Bean
    public DaoAuthenticationProvider s5804TnAuthProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setHideUserNotFoundExceptions(true); // Compliant - hides user not found
        return provider;
    }
}
