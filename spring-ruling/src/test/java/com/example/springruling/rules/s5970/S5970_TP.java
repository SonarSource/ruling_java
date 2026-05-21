package com.example.springruling.rules.s5970;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * S5970 - True Positive: Using assertEquals on ModelAndView.getViewName().
 *
 * Spring provides ModelAndViewAssert for testing ModelAndView objects. Using
 * assertEquals directly on getViewName() is less expressive and does not
 * leverage Spring's test utilities. SonarJava should flag this.
 */
class S5970_TP {

    @Test
    void testViewName() {
        ModelAndView mav = new ModelAndView("home");
        // Noncompliant - should use ModelAndViewAssert.assertViewName()
        assertEquals("home", mav.getViewName());
    }
}
