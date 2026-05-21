package com.example.springruling.rules.s6829;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.stereotype.Component;

/**
 * S6829 - True Positive: Multiple constructors, none annotated with @Autowired.
 *
 * When a Spring component has multiple constructors and none is annotated with
 * @Autowired, Spring cannot determine which constructor to use for dependency
 * injection and will fall back to the no-arg constructor (if present) or fail.
 * The developer should annotate exactly one constructor with @Autowired.
 * SonarJava should flag this as a violation of S6829.
 */
@Component
public class S6829_TP {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    // Noncompliant - multiple constructors, none annotated with @Autowired
    public S6829_TP(ServiceA serviceA) {
        this.serviceA = serviceA;
        this.serviceB = null;
    }

    public S6829_TP(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    public void doWork() {
        serviceA.doWork();
        if (serviceB != null) {
            serviceB.doWork();
        }
    }
}
