package com.example.springruling.rules.s4488;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S4488 - True Negative: Using the composed @GetMapping annotation.
 *
 * @GetMapping is the preferred shortcut for @RequestMapping(method = GET).
 * SonarJava should NOT flag this.
 */
@Controller
public class S4488_TN {

    @GetMapping("/s4488/tn/users") // Compliant - composed annotation used
    @ResponseBody
    public String getUsers() {
        return "users";
    }
}
