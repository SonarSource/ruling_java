package com.example.springruling.rules.s4288;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S4288 - True Positive: Setter injection via @Autowired in a @Component.
 *
 * The dependency "someService" is injected through a setter method annotated
 * with @Autowired. Spring best practices recommend constructor injection
 * because it ensures that dependencies are provided at construction time,
 * supports immutability, and makes the component easier to test.
 * SonarJava should flag this as a violation of S4288.
 */
@Component
public class S4288_TP {

    private SomeService someService;

    @Autowired
    public void setSomeService(SomeService someService) { // Noncompliant - setter injection
        this.someService = someService;
    }

    public void doWork() {
        someService.process();
    }
}
