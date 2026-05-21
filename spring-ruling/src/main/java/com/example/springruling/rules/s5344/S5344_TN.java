package com.example.springruling.rules.s5344;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * S5344 - True Negative: PasswordEncoder bean returning BCryptPasswordEncoder.
 *
 * BCrypt is a strong, slow hashing algorithm designed for password storage.
 * It includes built-in salting and configurable work factor.
 * SonarJava should NOT flag this.
 */
@Configuration
public class S5344_TN {

    @Bean
    public PasswordEncoder s5344TnPasswordEncoder() {
        return new BCryptPasswordEncoder(); // Compliant - strong hashing
    }
}
