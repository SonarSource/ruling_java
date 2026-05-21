package com.example.springruling.rules.s3752;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S3752 - True Positive: @RequestMapping without specifying the HTTP method.
 *
 * Using @RequestMapping without the method attribute allows all HTTP methods
 * (GET, POST, PUT, DELETE, etc.) to reach this endpoint, which is a security
 * concern. Routes should restrict the allowed HTTP methods explicitly.
 * SonarJava should flag this as a violation of S3752.
 */
@RestController
@RequestMapping("/s3752")
public class S3752_TP {

    @RequestMapping("/tp/data") // Noncompliant - no method restriction
    public String getData() {
        return "data";
    }
}
