package com.example.springruling.rules.s3750;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * S3750 - False Positive: @Controller with @Scope("singleton").
 *
 * The developer explicitly sets the scope to "singleton", which is the default
 * anyway. This is redundant but not harmful. The rule may still flag it because
 * it detects any @Scope on a controller, even though "singleton" is the correct
 * default scope.
 */
@Controller
@Scope("singleton") // Explicit singleton - redundant but correct; may still be flagged
public class S3750_FP {

    @GetMapping("/s3750/fp/hello")
    public String hello() {
        return "hello";
    }
}
