package com.example.springruling.rules.s7183;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * S7183 - True Positive: @InitBinder method returning String instead of void.
 *
 * Methods annotated with @InitBinder must return void. The return value is
 * ignored by Spring MVC, and a non-void return type indicates a likely mistake.
 * SonarJava should flag this as a violation of S7183.
 */
@Controller
public class S7183_TP {

    @InitBinder // Noncompliant - should return void
    public String initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        return "bound"; // Return value is ignored by Spring - this is a mistake
    }
}
