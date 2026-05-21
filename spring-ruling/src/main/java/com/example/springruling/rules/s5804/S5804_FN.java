package com.example.springruling.rules.s5804;

import com.example.springruling.shared.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * S5804 - False Negative: User enumeration via a custom REST endpoint.
 *
 * This controller provides a user-lookup endpoint that reveals whether a
 * username exists in the system by returning different HTTP status codes.
 * The analyzer may not detect this because it does not involve
 * UsernameNotFoundException or Spring Security's authentication flow.
 */
@RestController
public class S5804_FN {

    private final UserRepository userRepository;

    public S5804_FN(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/s5804/fn/check-user")
    public ResponseEntity<String> checkUserExists(@RequestParam String username) {
        // User enumeration via REST endpoint - analyzer may not detect this
        var page = userRepository.findByUsername(username, PageRequest.of(0, 1));
        if (page.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok("User exists");
    }
}
