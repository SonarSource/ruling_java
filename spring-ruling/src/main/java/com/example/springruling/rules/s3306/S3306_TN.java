package com.example.springruling.rules.s3306;

import com.example.springruling.shared.SomeService;
import org.springframework.stereotype.Component;

/**
 * S3306 - True Negative: Constructor injection in a @Component.
 *
 * The dependency "someService" is injected via the constructor, which is the
 * recommended approach. The field is final, ensuring immutability.
 * SonarJava should NOT flag this.
 */
@Component
public class S3306_TN {

    private final SomeService someService; // Compliant - constructor injection

    public S3306_TN(SomeService someService) {
        this.someService = someService;
    }

    public void doWork() {
        someService.process();
    }
}
