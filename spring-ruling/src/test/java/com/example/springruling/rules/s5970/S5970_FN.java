package com.example.springruling.rules.s5970;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * S5970 - False Negative: Assertion on mav.getViewName() via helper method.
 *
 * The view name is extracted in a helper method and then asserted. The analyzer
 * may not trace the ModelAndView.getViewName() call through the helper.
 */
class S5970_FN {

    private String extractViewName(ModelAndView mav) {
        return mav.getViewName();
    }

    @Test
    void testViewNameViaHelper() {
        ModelAndView mav = new ModelAndView("home");
        // FN - assertion on view name extracted via helper
        String viewName = extractViewName(mav);
        assertEquals("home", viewName);
    }
}
