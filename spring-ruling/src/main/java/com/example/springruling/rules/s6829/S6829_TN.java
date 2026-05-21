package com.example.springruling.rules.s6829;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S6829 - True Negative: Multiple constructors, one annotated with @Autowired.
 *
 * One constructor is clearly marked with @Autowired, telling Spring which
 * constructor to use for dependency injection. The other constructor exists
 * for programmatic or test use. SonarJava should NOT flag this.
 */
@Component
public class S6829_TN {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Autowired // Compliant - one constructor annotated
    public S6829_TN(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    // Additional constructor for programmatic use
    public S6829_TN(ServiceA serviceA) {
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
