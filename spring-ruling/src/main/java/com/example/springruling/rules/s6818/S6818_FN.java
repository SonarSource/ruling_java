package com.example.springruling.rules.s6818;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

/**
 * S6818 - False Negative: Multiple constructors with @Inject instead of @Autowired.
 *
 * Both constructors are annotated with Jakarta's @Inject, which is functionally
 * equivalent to @Autowired. This causes the same problem — Spring cannot decide
 * which constructor to use. However, the rule likely only checks for @Autowired,
 * so this equivalent violation goes undetected.
 */
@Component
public class S6818_FN {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Inject // Likely not flagged — uses @Inject instead of @Autowired
    public S6818_FN(ServiceA serviceA) {
        this.serviceA = serviceA;
        this.serviceB = null;
    }

    @Inject // Likely not flagged — second @Inject constructor
    public S6818_FN(ServiceA serviceA, ServiceB serviceB) {
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
