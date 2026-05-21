package com.example.springruling.rules.s7183;

import org.springframework.web.bind.WebDataBinder;

/**
 * S7183 - False Positive: Non-controller method named initBinder returning String.
 *
 * This class is NOT a @Controller, and the method is not annotated with
 * @InitBinder. It just happens to be named "initBinder" and returns a String.
 * The rule should only apply to methods annotated with @InitBinder in controllers.
 * If the rule matches by method name, this would be a false positive.
 */
public class S7183_FP {

    /**
     * A regular method that configures a binder and returns a result.
     * Not annotated with @InitBinder, so the return type is irrelevant to S7183.
     */
    public String initBinder(WebDataBinder binder) { // Not annotated with @InitBinder - should not be flagged
        binder.setDisallowedFields("id");
        return "configured";
    }
}
