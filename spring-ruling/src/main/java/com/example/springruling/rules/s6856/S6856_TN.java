package com.example.springruling.rules.s6856;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6856 - True Negative: Path variable properly bound using explicit name.
 *
 * The @PathVariable("userId") annotation explicitly specifies the binding name,
 * which matches the {userId} template variable in the path.
 * SonarJava should NOT flag this.
 */
@RestController
public class S6856_TN {

    @GetMapping("/s6856/tn/users/{userId}")
    public String getUser(@PathVariable("userId") String id) { // Compliant - explicit name matches template
        return "user: " + id;
    }
}
