package com.example.springruling.rules.s6830;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * S6830 - True Positive: Bean names that violate naming conventions.
 *
 * Spring bean names should follow Java camelCase naming conventions.
 * "BAD_BEAN_NAME" uses SCREAMING_SNAKE_CASE and "Another-Bad-Name" uses
 * kebab-case with a capital letter, both of which violate conventions.
 * SonarJava should flag these as violations of S6830.
 */
public class S6830_TP {

    @Component("BAD_BEAN_NAME") // Noncompliant - SCREAMING_SNAKE_CASE
    public static class BadComponent {
        public void doWork() { }
    }

    @Configuration
    public static class BadConfig {

        @Bean("Another-Bad-Name") // Noncompliant - kebab-case with capital
        public SomeService badlyNamedBean() {
            return new SomeService();
        }
    }
}
