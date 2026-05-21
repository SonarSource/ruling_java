package com.example.springruling.rules.s5344;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * S5344 - False Positive: NoOpPasswordEncoder in a test configuration class.
 *
 * This configuration is annotated with @Profile("test") and is intended for
 * integration tests only, where password hashing adds unnecessary overhead.
 * However, since the file is in src/main, the analyzer will still flag
 * NoOpPasswordEncoder as insecure.
 */
@Profile("test")
@Configuration
public class S5344_FP {

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder s5344FpPasswordEncoder() {
        // NoOpPasswordEncoder for test profile only - analyzer still flags it
        return NoOpPasswordEncoder.getInstance();
    }
}
