package com.example.springruling.rules.s4684;

import com.example.springruling.shared.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S4684 - False Negative: Entity wrapped in another object.
 *
 * The JPA entity is embedded inside a wrapper object. The mass assignment
 * vulnerability still exists because the attacker can set arbitrary fields
 * on the nested entity, but the analyzer may not detect it because the
 * top-level parameter type is not itself a JPA entity.
 */
@RestController
public class S4684_FN {

    @PostMapping("/s4684/fn/users")
    public String createUser(@RequestBody UserWrapper wrapper) { // Entity hidden inside wrapper - analyzer may miss this
        UserEntity user = wrapper.getUser();
        return "created: " + user.getUsername();
    }

    /**
     * Wrapper class that contains a JPA entity. The analyzer may not inspect
     * nested fields to detect the entity inside.
     */
    static class UserWrapper {
        private UserEntity user;

        public UserEntity getUser() { return user; }
        public void setUser(UserEntity user) { this.user = user; }
    }
}
