package com.example.springruling.rules.s6837;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6837 - False Positive: @ResponseBody from a custom annotation on a @RestController method.
 *
 * The method uses a custom @ApiEndpoint annotation that includes @ResponseBody.
 * This is technically redundant inside a @RestController, but the developer may
 * not be aware that their custom annotation carries @ResponseBody. The rule may
 * flag the custom annotation's @ResponseBody, which could confuse the developer.
 */
@RestController
public class S6837_FP {

    /**
     * Custom annotation that includes @ResponseBody.
     * The developer may not realize this is redundant inside @RestController.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ResponseBody
    @interface ApiEndpoint {
    }

    @GetMapping("/s6837/fp/data")
    @ApiEndpoint // Carries @ResponseBody via meta-annotation - redundant but non-obvious
    public String getData() {
        return "data";
    }
}
