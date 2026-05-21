package com.example.springruling.rules.s4488;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S4488 - False Negative: @RequestMapping(method = GET) inside a custom annotation.
 *
 * The custom @ApiGet annotation wraps @RequestMapping(method = RequestMethod.GET).
 * This is functionally equivalent to a direct @RequestMapping(method = GET) and
 * could be replaced with @GetMapping, but the analyzer may not resolve the
 * meta-annotation to detect the issue.
 */
@Controller
public class S4488_FN {

    /**
     * Custom annotation wrapping @RequestMapping with method = GET.
     * The analyzer may not resolve this to suggest using @GetMapping instead.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @RequestMapping(method = RequestMethod.GET)
    @interface ApiGet {
        @SuppressWarnings("unused")
        String value() default "";
    }

    @ApiGet("/s4488/fn/users") // Uses @RequestMapping(method=GET) under the hood - analyzer may miss this
    @ResponseBody
    public String getUsers() {
        return "users";
    }
}
