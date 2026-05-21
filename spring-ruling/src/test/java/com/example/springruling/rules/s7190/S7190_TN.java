package com.example.springruling.rules.s7190;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * S7190 - True Negative: @BeforeTransaction void method, @AfterTransaction void no-arg.
 *
 * Both methods follow the correct contract: void return type, no parameters.
 * SonarJava should NOT flag these.
 */
class S7190_TN {

    @BeforeTransaction // Compliant - void, no params
    public void setupTransaction() {
        System.out.println("Before transaction");
    }

    @AfterTransaction // Compliant - void, no params
    public void cleanupTransaction() {
        System.out.println("After transaction");
    }

    @Test
    void testSomething() {
    }
}
