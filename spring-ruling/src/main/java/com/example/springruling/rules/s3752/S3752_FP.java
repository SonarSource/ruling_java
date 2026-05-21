package com.example.springruling.rules.s3752;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S3752 - False Positive: Class-level @RequestMapping used only as a base path.
 *
 * A class-level @RequestMapping without a method attribute is commonly used
 * to define a base path prefix for all handler methods in the controller.
 * The actual HTTP method restriction is applied at the method level via
 * @GetMapping. The rule may incorrectly flag the class-level annotation.
 */
@RestController
@RequestMapping("/s3752/fp") // Class-level base path - no method needed here; may be flagged
public class S3752_FP {

    @GetMapping("/data") // Method-level restriction is applied here
    @ResponseBody
    public String getData() {
        return "data";
    }
}
