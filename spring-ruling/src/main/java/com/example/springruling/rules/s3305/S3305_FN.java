package com.example.springruling.rules.s3305;

import com.example.springruling.shared.SomeService;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S3305 - False Negative: Field injection via @jakarta.inject.Inject in @Configuration.
 *
 * The field "someService" is injected via Jakarta's @Inject annotation (instead
 * of Spring's @Autowired) and is used inside a @Bean method. The rule likely
 * only checks for @Autowired, so this equivalent pattern goes undetected.
 * SonarJava should ideally flag this, but it may not.
 */
@Configuration
public class S3305_FN {

    @Inject
    private SomeService someService; // Likely not flagged — uses @Inject instead of @Autowired

    @Bean
    public Object myBean() {
        // Uses the @Inject field in a @Bean method — same anti-pattern as @Autowired
        someService.process();
        return someService.create();
    }
}
