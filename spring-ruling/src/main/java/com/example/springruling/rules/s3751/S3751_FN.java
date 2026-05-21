package com.example.springruling.rules.s3751;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * S3751 - False Negative: Private method annotated with a custom annotation
 * that is itself meta-annotated with @RequestMapping.
 *
 * The analyzer may not resolve the custom @CustomGet meta-annotation to detect
 * that this private method is effectively a request mapping handler.
 */
@Controller
public class S3751_FN {

    /**
     * Custom annotation that acts as a composed @RequestMapping variant.
     * The analyzer may not resolve this to detect the mapping.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @RequestMapping(method = RequestMethod.GET)
    @interface CustomGet {
        @SuppressWarnings("unused")
        String value() default "";
    }

    @CustomGet("/s3751/fn/data") // Private handler via custom annotation - analyzer may miss this
    private String getData() {
        return "data";
    }
}
