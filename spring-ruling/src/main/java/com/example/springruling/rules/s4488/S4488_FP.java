package com.example.springruling.rules.s4488;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S4488 - False Positive: @RequestMapping with multiple HTTP methods.
 *
 * There is no composed annotation that supports multiple methods at once
 * (e.g., GET and POST). Using @RequestMapping with multiple methods is the
 * only way to achieve this. The rule may still flag it, but there is no
 * composed alternative available.
 */
@Controller
public class S4488_FP {

    @RequestMapping(value = "/s4488/fp/data", method = {RequestMethod.GET, RequestMethod.POST}) // No composed alternative for multiple methods
    @ResponseBody
    public String handleData() {
        return "data";
    }
}
