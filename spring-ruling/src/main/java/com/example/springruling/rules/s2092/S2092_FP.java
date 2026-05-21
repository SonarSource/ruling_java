package com.example.springruling.rules.s2092;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S2092 - False Positive: Cookie without "secure" flag in a dev-only profile.
 *
 * This controller is annotated with @Profile("dev"), so it only activates in
 * development environments where HTTPS is typically not configured. The cookie
 * intentionally omits setSecure(true) to allow local HTTP testing.
 * The analyzer may still flag this, but it is a legitimate dev-only pattern.
 */
@Profile("dev")
@RestController
public class S2092_FP {

    @GetMapping("/s2092/fp/login")
    public String devLogin(HttpServletResponse response) {
        Cookie devCookie = new Cookie("DEV_SESSION", "dev-token-xyz"); // Intentionally insecure for dev
        devCookie.setHttpOnly(true);
        devCookie.setPath("/");
        // Deliberately not setting secure flag - dev environment uses HTTP
        response.addCookie(devCookie);
        return "logged in (dev)";
    }
}
