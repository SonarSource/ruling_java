package com.example.springruling.rules.s3751;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * S3751 - True Positive: @Controller with a private @RequestMapping method.
 *
 * Methods annotated with @RequestMapping in a @Controller must be accessible
 * by the Spring framework (i.e., not private). A private method cannot be
 * invoked by Spring MVC's dispatcher.
 * SonarJava should flag this as a violation of S3751.
 */
@Controller
public class S3751_TP {

    @RequestMapping("/s3751/tp/data") // Noncompliant - method is private
    private String getData() {
        return "data";
    }
}
