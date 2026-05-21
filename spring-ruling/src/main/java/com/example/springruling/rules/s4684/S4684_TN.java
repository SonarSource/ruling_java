package com.example.springruling.rules.s4684;

import com.example.springruling.shared.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S4684 - True Negative: DTO used as @RequestBody parameter (not a JPA entity).
 *
 * Using a DTO (Data Transfer Object) instead of a JPA entity prevents mass
 * assignment attacks. The DTO only exposes the fields that should be set by
 * the user.
 * SonarJava should NOT flag this.
 */
@RestController
public class S4684_TN {

    @PostMapping("/s4684/tn/users")
    public String createUser(@RequestBody UserDto userDto) { // Compliant - DTO, not entity
        return "created: " + userDto.getUsername();
    }
}
