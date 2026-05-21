package com.example.springruling.rules.s7177;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

/**
 * S7177 - True Positive: @DirtiesContext with wrong control mode.
 *
 * On a CLASS: using methodMode is wrong (should use classMode).
 * On a METHOD: using classMode is wrong (should use methodMode).
 *
 * SonarJava should flag:
 * - methodMode on a class
 * - classMode on a method
 */
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD) // Noncompliant - should use classMode on a class
class S7177_TP {

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) // Noncompliant - should use methodMode on a method
    @Test
    void testOne() {
        // Test that modifies context state
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD) // Compliant - methodMode on a method is correct
    @Test
    void testTwo() {
        // Another test
    }

    @Test
    void testThree() {
        // Regular test without DirtiesContext
    }
}
