package com.example.springruling.rules.s6862;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6862 - True Positive: Two @Bean methods with the same method name.
 *
 * The check looks at the actual method name (not the @Bean name attribute).
 * Having two @Bean methods with the same name in a @Configuration class
 * causes one to silently override the other. The developer likely intended
 * to register two different beans but accidentally used the same method name.
 * SonarJava should flag the second occurrence.
 */
@Configuration
public class S6862_TP {

    @Bean
    public SomeService myBean() {
        return new SomeService();
    }

    @Bean
    public SomeService myBean(String name) { // Noncompliant - same method name as above
        return new SomeService();
    }
}
