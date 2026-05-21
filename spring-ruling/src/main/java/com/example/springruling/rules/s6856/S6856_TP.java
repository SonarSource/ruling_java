package com.example.springruling.rules.s6856;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6856 - True Positive: Path variable name mismatch.
 *
 * The path template has {userId} but the @PathVariable parameter is named "id"
 * without specifying the binding name. Spring cannot bind the path variable
 * because the parameter name does not match the template variable name.
 * SonarJava should flag this as a violation of S6856.
 */
@RestController
public class S6856_TP {

    @GetMapping("/s6856/tp/users/{userId}")
    public String getUser(@PathVariable String id) { // Noncompliant - "id" does not match "{userId}"
        return "user: " + id;
    }
}
