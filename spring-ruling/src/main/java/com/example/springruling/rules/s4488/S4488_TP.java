package com.example.springruling.rules.s4488;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S4488 - True Positive: @RequestMapping with explicit method attribute
 * where a composed variant exists.
 *
 * Using @RequestMapping(value="/users", method=RequestMethod.GET) is verbose.
 * The composed annotation @GetMapping("/users") should be preferred.
 * SonarJava should flag this as a violation of S4488.
 */
@Controller
public class S4488_TP {

    @RequestMapping(value = "/s4488/tp/users", method = RequestMethod.GET) // Noncompliant - should use @GetMapping
    @ResponseBody
    public String getUsers() {
        return "users";
    }
}
