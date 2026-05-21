package com.example.springruling.rules.s2092;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S2092 - True Negative: Cookie created with the "secure" flag properly set.
 *
 * The cookie has setSecure(true) called before being added to the response,
 * ensuring it is only transmitted over HTTPS. SonarJava should NOT flag this.
 */
@RestController
public class S2092_TN {

    @GetMapping("/s2092/tn/login")
    public String login(HttpServletResponse response) {
        Cookie sessionCookie = new Cookie("SESSION_ID", "abc123"); // Compliant
        sessionCookie.setHttpOnly(true);
        sessionCookie.setSecure(true);
        sessionCookie.setPath("/");
        response.addCookie(sessionCookie);
        return "logged in";
    }
}
