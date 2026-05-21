package com.example.springruling.rules.s3749;

import com.example.springruling.shared.SomeService;
import org.springframework.stereotype.Service;

/**
 * S3749 - True Positive: Non-injected instance field in a @Service.
 *
 * The field "someService" is neither injected (@Autowired, @Inject, @Value)
 * nor initialized. In a Spring component, such fields will be null at runtime
 * and will cause NullPointerException when accessed. SonarJava should flag
 * this as a violation of S3749.
 */
@Service
public class S3749_TP {

    private SomeService someService; // Noncompliant - not injected, will be null

    public void doWork() {
        someService.process(); // Will throw NPE at runtime
    }
}
