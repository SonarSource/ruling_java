package com.example.springruling.rules.s2229;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2229 - False Positive: Two methods with the same propagation (both REQUIRED).
 *
 * Both methods share the same propagation level, so the self-call has no semantic
 * difference whether or not it goes through the proxy. An analyzer might still flag
 * this as a problematic self-call, but it is functionally harmless.
 */
@Service
public class S2229_FP {

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodOne() {
        // Same propagation - self-call is not harmful
        methodTwo();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodTwo() {
        // Both REQUIRED - no incompatibility
    }
}
