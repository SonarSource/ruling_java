package com.example.springruling.rules.s2229;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2229 - True Negative: Compatible propagation, or call through injected self-reference.
 *
 * Both methods use compatible propagation (REQUIRED), and the self-reference call
 * goes through the proxy via @Lazy self-injection. SonarJava should NOT flag this.
 */
@Service
public class S2229_TN {

    @Autowired
    @Lazy
    private S2229_TN self;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void outerMethod() {
        // Compliant - call goes through proxy via injected self-reference
        self.innerMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void innerMethod() {
        // Business logic
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodA() {
        // Compliant - same propagation, self-call is fine
        methodB();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodB() {
        // Compatible propagation
    }
}
