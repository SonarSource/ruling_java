package com.example.springruling.rules.s5344;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * S5344 - True Positive: PasswordEncoder bean returning NoOpPasswordEncoder.
 *
 * NoOpPasswordEncoder stores passwords in plaintext with no hashing.
 * This is completely insecure for production use and should be flagged.
 * SonarJava should report this as a violation of S5344.
 */
@Configuration
public class S5344_TP {

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder s5344TpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Noncompliant - plaintext passwords
    }
}
