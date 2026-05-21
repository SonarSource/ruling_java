package com.example.springruling.rules.s3305;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S3305 - True Positive: @Autowired field injection in a @Configuration class.
 *
 * The field "someService" is injected via @Autowired and then used inside a @Bean
 * factory method. Spring recommends using method parameter injection in @Bean
 * methods instead of field injection at the class level. SonarJava should flag
 * this as a violation of S3305.
 */
@Configuration
public class S3305_TP {

    @Autowired
    private SomeService someService; // Noncompliant - field injection used in @Bean method

    @Bean
    public Object myBean() {
        // Uses the @Autowired field — should use parameter injection instead
        someService.process();
        return someService.create();
    }
}
