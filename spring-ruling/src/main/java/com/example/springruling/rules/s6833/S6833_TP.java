package com.example.springruling.rules.s6833;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S6833 - True Positive: @Controller with class-level @ResponseBody.
 *
 * When a @Controller has @ResponseBody at the class level, it is functionally
 * identical to @RestController. The combined @RestController annotation should
 * be used instead for clarity and conciseness.
 * SonarJava should flag this as a violation of S6833.
 */
@Controller
@ResponseBody // Noncompliant - should use @RestController instead
public class S6833_TP {

    @GetMapping("/s6833/tp/data")
    public String getData() {
        return "data";
    }

    @GetMapping("/s6833/tp/info")
    public String getInfo() {
        return "info";
    }
}
