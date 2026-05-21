package com.example.springruling.rules.s7190;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * S7190 - True Positive: @BeforeTransaction returning String (should be void),
 * @AfterTransaction with parameters (should have none).
 *
 * @BeforeTransaction methods must return void and @AfterTransaction methods
 * must have no parameters. SonarJava should flag both violations.
 */
class S7190_TP {

    @BeforeTransaction // Noncompliant - should return void
    public String setupTransaction() {
        return "setup";
    }

    @AfterTransaction // Noncompliant - should have no parameters
    public void cleanupTransaction(String context) {
        System.out.println("Cleanup: " + context);
    }

    @Test
    void testSomething() {
    }
}
