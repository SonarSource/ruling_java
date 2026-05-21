package com.example.springruling.rules.s3751;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * S3751 - False Positive: @RequestMapping method in a plain class (not a controller).
 *
 * This class is NOT annotated with @Controller or @RestController, so the
 * @RequestMapping annotation has no effect. The private access modifier is
 * irrelevant since this method will never be dispatched by Spring MVC.
 * The rule might still flag it if it only checks for private + @RequestMapping
 * without verifying the class is a controller.
 */
public class S3751_FP {

    @RequestMapping("/s3751/fp/data") // Not in a controller - should not be flagged
    private String getData() {
        return "data";
    }
}
