package com.example.springruling.rules.s5970;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

/**
 * S5970 - True Negative: Using ModelAndViewAssert.assertViewName().
 *
 * This is the recommended approach using Spring's test utility class.
 * SonarJava should NOT flag this.
 */
class S5970_TN {

    @Test
    void testViewName() {
        ModelAndView mav = new ModelAndView("home");
        // Compliant - using Spring's ModelAndViewAssert
        ModelAndViewAssert.assertViewName(mav, "home");
    }
}
