package com.example.springruling.rules.s3750;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * S3750 - True Positive: @Controller annotated with @Scope("prototype").
 *
 * Spring controllers should not use @Scope because controllers are typically
 * singletons managed by the Spring container. Using prototype scope on a
 * controller can lead to unexpected behavior and performance issues.
 * SonarJava should flag this as a violation of S3750.
 */
@Controller
@Scope("prototype") // Noncompliant - controllers should not use @Scope
public class S3750_TP {

    @GetMapping("/s3750/tp/hello")
    public String hello() {
        return "hello";
    }
}
