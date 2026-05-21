package com.example.springruling.rules.s7177;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 * S7177 - True Negative: @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD) or
 * no @DirtiesContext at all.
 *
 * AFTER_EACH_TEST_METHOD resets the context after each test, preventing stale state.
 * No @DirtiesContext means the context is shared (the default, which is fine).
 * SonarJava should NOT flag either pattern.
 */
class S7177_TN {

    @DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
    static class WithDirtiesContextPerMethod {

        @Test
        void testOne() {
        }

        @Test
        void testTwo() {
        }
    }

    static class WithoutDirtiesContext {

        @Test
        void testOne() {
        }

        @Test
        void testTwo() {
        }
    }
}
