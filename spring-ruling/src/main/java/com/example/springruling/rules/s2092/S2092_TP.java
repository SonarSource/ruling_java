package com.example.springruling.rules.s2092;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S2092 - True Positive: Cookie created without the "secure" flag.
 *
 * The cookie is added to the response without calling setSecure(true),
 * meaning it can be transmitted over unencrypted HTTP connections.
 * SonarJava should flag this as a violation of S2092.
 */
@RestController
public class S2092_TP {

    @GetMapping("/s2092/tp/login")
    public String login(HttpServletResponse response) {
        Cookie sessionCookie = new Cookie("SESSION_ID", "abc123"); // Noncompliant - no setSecure(true)
        sessionCookie.setHttpOnly(true);
        sessionCookie.setPath("/");
        // Missing: sessionCookie.setSecure(true);
        response.addCookie(sessionCookie);
        return "logged in";
    }
}
