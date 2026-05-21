package com.example.springruling.rules.s3306;

import com.example.springruling.shared.SomeService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

/**
 * S3306 - False Negative: Field injection via @jakarta.inject.Inject.
 *
 * The field "someService" is injected using Jakarta's @Inject annotation instead
 * of Spring's @Autowired. This is functionally equivalent field injection, and
 * should be flagged the same way. However, the rule may only look for @Autowired,
 * causing this to be missed.
 */
@Component
public class S3306_FN {

    @Inject
    private SomeService someService; // Likely not flagged — uses @Inject instead of @Autowired

    public void doWork() {
        someService.process();
    }
}
