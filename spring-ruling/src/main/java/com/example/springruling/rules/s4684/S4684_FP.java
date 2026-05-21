package com.example.springruling.rules.s4684;

import com.example.springruling.shared.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S4684 - False Positive: @Entity returned in @ResponseBody (not as input).
 *
 * The entity is only used as a return value (output), not as a request body
 * (input). Mass assignment only applies when the entity is used to receive
 * user input. Returning an entity is a separate concern (data exposure) but
 * not a mass assignment vulnerability. The rule may still flag this.
 */
@RestController
public class S4684_FP {

    @GetMapping("/s4684/fp/users/1")
    @ResponseBody
    public UserEntity getUser() { // Entity used as output only - not a mass assignment risk
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("alice");
        user.setEmail("alice@example.com");
        return user;
    }
}
