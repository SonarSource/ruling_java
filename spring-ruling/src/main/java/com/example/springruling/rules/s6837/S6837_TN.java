package com.example.springruling.rules.s6837;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S6837 - True Negative: @ResponseBody on a method in a @Controller (not @RestController).
 *
 * In a @Controller, @ResponseBody on a method is necessary to indicate that
 * the return value should be written directly to the response body instead of
 * being resolved as a view name. This is not redundant.
 * SonarJava should NOT flag this.
 */
@Controller
public class S6837_TN {

    @GetMapping("/s6837/tn/data")
    @ResponseBody // Compliant - needed in a @Controller to return response body
    public String getData() {
        return "data";
    }
}
