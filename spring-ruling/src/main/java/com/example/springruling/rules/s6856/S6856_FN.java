package com.example.springruling.rules.s6856;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6856 - False Negative: @PathVariable matching by parameter name with
 * -parameters compiler flag.
 *
 * When compiled with -parameters (which this project uses in pom.xml),
 * Spring can resolve @PathVariable by the actual parameter name at runtime.
 * Here the parameter is named "userId" which matches the {userId} template,
 * so this works at runtime. However, without the -parameters flag it would
 * fail. The analyzer may not consider the compiler flag and could either
 * flag or not flag this depending on its assumptions.
 */
@RestController
public class S6856_FN {

    @GetMapping("/s6856/fn/users/{userId}")
    public String getUser(@PathVariable String userId) { // Works with -parameters flag; may be missed without it
        return "user: " + userId;
    }
}
