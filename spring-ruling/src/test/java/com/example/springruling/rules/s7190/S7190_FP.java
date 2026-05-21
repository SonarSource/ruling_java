package com.example.springruling.rules.s7190;

import org.junit.jupiter.api.Test;

/**
 * S7190 - False Positive: Method named beforeTransaction without annotation.
 *
 * The method is named beforeTransaction but is NOT annotated with @BeforeTransaction.
 * It is a regular method and does not need to follow the @BeforeTransaction contract.
 * The analyzer might flag it based on naming convention alone.
 */
class S7190_FP {

    // FP - no @BeforeTransaction annotation, just a method name
    public String beforeTransaction() {
        return "prepared";
    }

    public void afterTransaction(String context) {
        System.out.println("After: " + context);
    }

    @Test
    void testSomething() {
    }
}
