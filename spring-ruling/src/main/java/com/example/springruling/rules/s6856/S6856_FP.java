package com.example.springruling.rules.s6856;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

/**
 * S6856 - False Positive: Path variable bound via HttpServletRequest.
 *
 * Instead of using @PathVariable, the developer extracts the path variable
 * manually from the HttpServletRequest using the URI_TEMPLATE_VARIABLES_ATTRIBUTE.
 * The rule may flag the missing @PathVariable binding, but the variable is
 * actually extracted at runtime through the request attributes.
 */
@RestController
public class S6856_FP {

    @SuppressWarnings("unchecked")
    @GetMapping("/s6856/fp/users/{userId}")
    public String getUser(HttpServletRequest request) { // No @PathVariable - bound via request attribute
        java.util.Map<String, String> pathVars =
            (java.util.Map<String, String>) request.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String userId = pathVars != null ? pathVars.get("userId") : "unknown";
        return "user: " + userId;
    }
}
