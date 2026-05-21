package com.example.springruling.rules.s6833;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6833 - True Negative: Using @RestController directly.
 *
 * @RestController is the correct combined annotation that includes both
 * @Controller and @ResponseBody. This is the preferred approach.
 * SonarJava should NOT flag this.
 */
@RestController // Compliant - @RestController used directly
public class S6833_TN {

    @GetMapping("/s6833/tn/data")
    public String getData() {
        return "data";
    }

    @GetMapping("/s6833/tn/info")
    public String getInfo() {
        return "info";
    }
}
