package com.example.springruling.rules.s4288;

import com.example.springruling.shared.SomeService;
import org.springframework.stereotype.Component;

/**
 * S4288 - True Negative: Constructor injection in a @Component.
 *
 * The dependency "someService" is injected via the constructor, which is the
 * recommended Spring pattern. The field is final, ensuring immutability.
 * SonarJava should NOT flag this.
 */
@Component
public class S4288_TN {

    private final SomeService someService; // Compliant - constructor injection

    public S4288_TN(SomeService someService) {
        this.someService = someService;
    }

    public void doWork() {
        someService.process();
    }
}
