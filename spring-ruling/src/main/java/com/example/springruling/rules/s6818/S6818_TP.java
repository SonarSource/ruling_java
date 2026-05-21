package com.example.springruling.rules.s6818;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S6818 - True Positive: @Autowired on two constructors.
 *
 * Spring does not support @Autowired(required=true) on more than one
 * constructor. When multiple constructors are annotated with @Autowired,
 * Spring throws a BeanCreationException at startup.
 * SonarJava should flag this as a violation of S6818.
 */
@Component
public class S6818_TP {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @Autowired // Noncompliant - multiple constructors with @Autowired
    public S6818_TP(ServiceA serviceA) {
        this.serviceA = serviceA;
        this.serviceB = null;
    }

    @Autowired // Noncompliant - second @Autowired constructor
    public S6818_TP(ServiceA serviceA, ServiceB serviceB) {
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
