package com.example.springruling.rules.s6837;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6837 - True Positive: @ResponseBody on a method inside a @RestController.
 *
 * @RestController already includes @ResponseBody at the class level, so adding
 * @ResponseBody on individual methods is redundant and superfluous.
 * SonarJava should flag this as a violation of S6837.
 */
@RestController
public class S6837_TP {

    @GetMapping("/s6837/tp/data")
    @ResponseBody // Noncompliant - redundant, @RestController already implies @ResponseBody
    public String getData() {
        return "data";
    }
}
