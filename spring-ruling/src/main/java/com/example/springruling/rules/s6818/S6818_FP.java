package com.example.springruling.rules.s6818;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S6818 - False Positive: Multiple constructors with @Autowired(required=false).
 *
 * Spring explicitly supports multiple constructors annotated with
 * @Autowired(required=false). In this case Spring picks the constructor whose
 * dependencies can all be satisfied, with the "greediest" match winning.
 * This is a documented and valid Spring pattern. Flagging it would be a
 * false positive.
 */
@Component
public class S6818_FP {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Autowired(required = false) // Compliant - required=false allows multiple
    public S6818_FP(ServiceA serviceA) {
        this.serviceA = serviceA;
        this.serviceB = null;
    }

    @Autowired(required = false) // Compliant - required=false allows multiple
    public S6818_FP(ServiceA serviceA, ServiceB serviceB) {
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
