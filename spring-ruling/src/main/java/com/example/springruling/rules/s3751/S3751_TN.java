package com.example.springruling.rules.s3751;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * S3751 - True Negative: @Controller with a public @RequestMapping method.
 *
 * The handler method is public, which is the correct access level for Spring
 * MVC to dispatch requests to it.
 * SonarJava should NOT flag this.
 */
@Controller
public class S3751_TN {

    @RequestMapping("/s3751/tn/data") // Compliant - method is public
    public String getData() {
        return "data";
    }
}
