package com.example.springruling.rules.s4684;

import com.example.springruling.shared.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S4684 - True Positive: JPA entity used directly as @RequestBody parameter.
 *
 * Accepting a JPA @Entity directly as a request body exposes the application
 * to mass assignment attacks. An attacker can set fields like "role" or "id"
 * that should not be user-controllable. A DTO should be used instead.
 * SonarJava should flag this as a violation of S4684.
 */
@RestController
public class S4684_TP {

    @PostMapping("/s4684/tp/users")
    public String createUser(@RequestBody UserEntity user) { // Noncompliant - JPA entity as request body
        // Attacker could set user.setRole("ADMIN") or user.setId(1L)
        return "created: " + user.getUsername();
    }
}
