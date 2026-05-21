package com.example.springruling.rules.s7177;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 * S7177 - False Positive: @DirtiesContext on single-test class (intentional reset).
 *
 * When there is only one test method, AFTER_CLASS and AFTER_EACH_TEST_METHOD
 * are equivalent. The developer may intentionally use AFTER_CLASS for clarity.
 * The analyzer might flag it, but it is harmless.
 */
@DirtiesContext(classMode = ClassMode.AFTER_CLASS) // FP - single test, mode doesn't matter
class S7177_FP {

    @Test
    void singleTest() {
        // Only one test, AFTER_CLASS is fine
    }
}
