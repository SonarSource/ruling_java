package com.example.springruling.rules.s5970;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * S5970 - False Positive: assertEquals on non-ModelAndView value in the same test.
 *
 * Using assertEquals to compare plain strings has nothing to do with ModelAndView.
 * The analyzer might flag assertEquals calls in test classes that also deal with
 * ModelAndView, but this assertion is unrelated.
 */
class S5970_FP {

    @Test
    void testRegularAssertion() {
        String expected = "hello";
        String actual = "hello";
        // FP - assertEquals on regular strings, not ModelAndView
        assertEquals(expected, actual);
    }
}
