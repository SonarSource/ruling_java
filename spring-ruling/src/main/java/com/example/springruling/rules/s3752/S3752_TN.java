package com.example.springruling.rules.s3752;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S3752 - True Negative: @GetMapping and @RequestMapping with explicit method.
 *
 * Both approaches restrict the allowed HTTP method. @GetMapping is a shortcut
 * for @RequestMapping(method = RequestMethod.GET). SonarJava should NOT flag these.
 */
@Controller
public class S3752_TN {

    @GetMapping("/s3752/tn/data1") // Compliant - restricted to GET
    @ResponseBody
    public String getData1() {
        return "data1";
    }

    @RequestMapping(value = "/s3752/tn/data2", method = RequestMethod.GET) // Compliant - method specified
    @ResponseBody
    public String getData2() {
        return "data2";
    }
}
