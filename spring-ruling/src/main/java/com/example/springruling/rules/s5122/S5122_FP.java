package com.example.springruling.rules.s5122;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S5122 - False Positive: Wildcard CORS on an intentionally public API.
 *
 * This controller serves a deliberately public API (e.g., a public CDN endpoint
 * or open data feed) where wildcard CORS is the correct policy. The API does
 * not serve sensitive data, so allowing all origins is appropriate.
 * The analyzer will still flag origins="*" regardless of intent.
 */
@RestController
public class S5122_FP {

    @CrossOrigin(origins = "*") // Intentionally public API - analyzer flags anyway
    @GetMapping("/s5122/fp/public-feed")
    public String getPublicFeed() {
        // This endpoint intentionally serves public, non-sensitive data
        return "{\"status\": \"ok\", \"version\": \"1.0\"}";
    }
}
