package com.example.springruling.rules.s4288;

import com.example.springruling.shared.SomeService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

/**
 * S4288 - False Negative: Field injection via @jakarta.inject.Inject.
 *
 * The field "someService" is injected using Jakarta's @Inject annotation.
 * This is functionally equivalent to @Autowired field injection and should
 * also be flagged as a violation. However, the rule may only detect
 * @Autowired annotations, causing this to be missed.
 */
@Component
public class S4288_FN {

    @Inject
    private SomeService someService; // Likely not flagged — uses @Inject instead of @Autowired

    public void doWork() {
        someService.process();
    }
}
