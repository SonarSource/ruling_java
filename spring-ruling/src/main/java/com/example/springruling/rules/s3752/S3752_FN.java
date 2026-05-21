package com.example.springruling.rules.s3752;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S3752 - False Negative: @RequestMapping where the method is set via a
 * custom composed annotation.
 *
 * The custom @SafeGet annotation specifies method = RequestMethod.GET, so
 * the route is actually restricted. However, if the developer removes the
 * method attribute from the custom annotation in the future, this endpoint
 * would become unrestricted. The analyzer may not resolve the meta-annotation
 * and could miss cases where the method attribute is NOT specified inside the
 * custom annotation.
 */
@Controller
public class S3752_FN {

    /**
     * Custom composed annotation that restricts to GET.
     * The analyzer may not resolve this to check the method attribute.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @RequestMapping(method = RequestMethod.GET)
    @interface SafeGet {
        @SuppressWarnings("unused")
        String value() default "";
    }

    @SafeGet("/s3752/fn/data") // Method restricted via meta-annotation - analyzer may miss this
    @ResponseBody
    public String getData() {
        return "data";
    }
}
