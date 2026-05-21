package com.example.springruling.rules.s5344;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * S5344 - False Negative: Custom PasswordEncoder that internally uses weak hashing.
 *
 * This class provides a custom PasswordEncoder implementation that internally
 * uses a simple, fast, and insecure hashing approach (plain hashCode).
 * The analyzer may not detect this because it does not use NoOpPasswordEncoder
 * or any other known-weak encoder class - it just implements the interface directly.
 */
@Configuration
public class S5344_FN {

    @Bean
    public PasswordEncoder s5344FnPasswordEncoder() {
        // Custom encoder using weak hashing - analyzer may not detect this
        return new WeakCustomPasswordEncoder();
    }

    /**
     * A custom PasswordEncoder that uses a trivially weak hashing mechanism.
     * The analyzer typically checks for known-weak classes like NoOpPasswordEncoder
     * but may not inspect custom implementations for weak algorithms.
     */
    static class WeakCustomPasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence rawPassword) {
            // Insecure: using simple hashCode (fast, no salt, reversible via rainbow tables)
            return String.valueOf(rawPassword.toString().hashCode());
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encode(rawPassword).equals(encodedPassword);
        }
    }
}
