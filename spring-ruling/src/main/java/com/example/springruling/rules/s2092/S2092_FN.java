package com.example.springruling.rules.s2092;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S2092 - False Negative: Secure flag set via a helper method.
 *
 * The cookie's secure flag IS set, but through an indirection (helper method).
 * The analyzer might not trace the data flow through the helper and could miss
 * that the cookie is actually compliant, or conversely might not flag a case
 * where the helper is called but the flag is NOT truly set. Here the helper
 * does set the flag, so the code is actually compliant, but wrapping setSecure
 * in a helper could also be used to hide a missing secure flag from the analyzer.
 */
@RestController
public class S2092_FN {

    @GetMapping("/s2092/fn/login")
    public String login(HttpServletResponse response) {
        Cookie sessionCookie = new Cookie("SESSION_ID", "abc123");
        sessionCookie.setHttpOnly(true);
        sessionCookie.setPath("/");
        applySecurityDefaults(sessionCookie); // Secure flag set via helper - analyzer may not follow
        response.addCookie(sessionCookie);
        return "logged in";
    }

    /**
     * Helper method that applies security defaults to a cookie.
     * The analyzer may not trace into this method to verify setSecure is called.
     */
    private void applySecurityDefaults(Cookie cookie) {
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
    }
}
