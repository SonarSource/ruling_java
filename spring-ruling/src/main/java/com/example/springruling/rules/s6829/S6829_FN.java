package com.example.springruling.rules.s6829;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

/**
 * S6829 - False Negative: Multiple constructors with @Inject on one.
 *
 * One constructor is annotated with Jakarta's @Inject (not @Autowired). While
 * functionally equivalent, the rule likely only checks for @Autowired, so it
 * may report this class as having "multiple constructors, none @Autowired"
 * even though @Inject is present. Alternatively, if the rule does not
 * recognize @Inject, it misses that the class is actually correctly configured.
 */
@Component
public class S6829_FN {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Inject // @Inject used instead of @Autowired — may not be recognized
    public S6829_FN(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    public S6829_FN(ServiceA serviceA) {
        this.serviceA = serviceA;
        this.serviceB = null;
    }

    public void doWork() {
        serviceA.doWork();
        if (serviceB != null) {
            serviceB.doWork();
        }
    }
}
