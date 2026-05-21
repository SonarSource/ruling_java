package com.example.springruling.rules.s2229;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2229 - True Positive: incompatible @Transactional self-calls.
 *
 * A non-transactional public method calls a @Transactional(REQUIRED) method
 * on the same instance. Since Spring proxies don't intercept self-calls,
 * the transactional annotation is ignored. Additionally, a REQUIRED method
 * calls a REQUIRES_NEW method, which is also an incompatible self-call.
 */
@Service
public class S2229_TP {

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredMethod() {
        // Noncompliant - REQUIRED calling REQUIRES_NEW is incompatible
        requiresNewMethod();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewMethod() {
        // Business logic that should run in a new transaction
    }

    public void nonTransactionalMethod() {
        // Noncompliant - non-transactional calling REQUIRED is incompatible
        requiredMethod();
    }
}
