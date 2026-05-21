package com.example.springruling.rules.s3750;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * S3750 - True Negative: @Controller without @Scope annotation.
 *
 * This controller relies on the default singleton scope, which is the
 * correct and expected behavior for Spring controllers.
 * SonarJava should NOT flag this.
 */
@Controller
public class S3750_TN {

    @GetMapping("/s3750/tn/hello")
    public String hello() {
        return "hello";
    }
}
