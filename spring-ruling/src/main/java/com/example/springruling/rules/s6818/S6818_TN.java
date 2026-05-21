package com.example.springruling.rules.s6818;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S6818 - True Negative: Single @Autowired constructor.
 *
 * Only one constructor is annotated with @Autowired. The other constructor
 * is not annotated and exists for programmatic use (e.g., testing).
 * SonarJava should NOT flag this.
 */
@Component
public class S6818_TN {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Autowired // Compliant - only one constructor has @Autowired
    public S6818_TN(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    // Non-annotated constructor for programmatic/test use
    public S6818_TN(ServiceA serviceA) {
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
