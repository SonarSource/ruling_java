package com.example.springruling.rules.s7183;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * S7183 - True Negative: @InitBinder method with void return type.
 *
 * This is the correct signature for an @InitBinder method. The method properly
 * returns void and configures the WebDataBinder.
 * SonarJava should NOT flag this.
 */
@Controller
public class S7183_TN {

    @InitBinder // Compliant - returns void
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }
}
