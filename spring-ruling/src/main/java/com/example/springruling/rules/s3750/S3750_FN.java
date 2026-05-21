package com.example.springruling.rules.s3750;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * S3750 - False Negative: Controller with custom @PrototypeScope meta-annotation.
 *
 * The controller uses a custom meta-annotation that applies @Scope("prototype")
 * indirectly. The analyzer may not resolve the meta-annotation to detect the
 * prototype scope on the controller, resulting in a false negative.
 */
@Controller
@S3750_FN.PrototypeScope // Prototype scope applied via meta-annotation - analyzer may miss this
public class S3750_FN {

    /**
     * Custom meta-annotation that applies prototype scope.
     * The analyzer may not resolve this to detect the @Scope usage.
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Scope("prototype")
    @interface PrototypeScope {
    }

    @GetMapping("/s3750/fn/hello")
    public String hello() {
        return "hello";
    }
}
