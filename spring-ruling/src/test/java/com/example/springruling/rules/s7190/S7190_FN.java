package com.example.springruling.rules.s7190;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * S7190 - False Negative: @BeforeTransaction with default (package-private) visibility.
 *
 * The method has default visibility which is valid in JUnit 5, but the
 * @BeforeTransaction contract says the method should return void. Here it returns
 * int. The analyzer may miss this if it only checks public methods.
 */
class S7190_FN {

    @BeforeTransaction // FN - package-private method returning int, should be void
    int setupTransaction() {
        return 42;
    }

    @Test
    void testSomething() {
    }
}
