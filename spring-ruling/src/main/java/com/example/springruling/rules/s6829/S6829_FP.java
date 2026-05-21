package com.example.springruling.rules.s6829;

import com.example.springruling.shared.ServiceA;
import org.springframework.stereotype.Component;

/**
 * S6829 - False Positive: Multiple constructors where one is no-arg.
 *
 * When one of the constructors is a no-arg constructor, Spring will use it
 * as the default. This is a valid pattern — the no-arg constructor acts as
 * the implicit default, and Spring does not require @Autowired in this case.
 * Flagging this would be a false positive because the behavior is well-defined.
 */
@Component
public class S6829_FP {

    private ServiceA serviceA;

    // No-arg constructor — Spring uses this as default
    public S6829_FP() {
        // Default construction — potentially flagged but behavior is well-defined
    }

    public S6829_FP(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void doWork() {
        if (serviceA != null) {
            serviceA.doWork();
        }
    }
}
