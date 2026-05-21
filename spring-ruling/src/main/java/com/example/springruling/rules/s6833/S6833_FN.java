package com.example.springruling.rules.s6833;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S6833 - False Negative: @ResponseBody applied via a custom meta-annotation.
 *
 * The controller uses a custom @ApiResponse annotation that includes @ResponseBody.
 * This is functionally equivalent to having @ResponseBody at the class level,
 * meaning the controller should be @RestController. The analyzer may not resolve
 * the meta-annotation to detect the @ResponseBody presence.
 */
@Controller
@S6833_FN.ApiResponse // @ResponseBody applied via meta-annotation - analyzer may miss this
public class S6833_FN {

    /**
     * Custom meta-annotation that includes @ResponseBody.
     * The analyzer may not resolve this to detect the @ResponseBody.
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @ResponseBody
    @interface ApiResponse {
    }

    @GetMapping("/s6833/fn/data")
    public String getData() {
        return "data";
    }

    @GetMapping("/s6833/fn/info")
    public String getInfo() {
        return "info";
    }
}
