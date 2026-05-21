package com.example.springruling.rules.s6831;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * S6831 - False Negative: Custom qualifier annotation (meta-annotated with @Qualifier)
 * on a @Bean method.
 *
 * The custom annotation @MyQualifier is meta-annotated with @Qualifier, making
 * it functionally equivalent. Using it on a @Bean method has the same issue as
 * using @Qualifier directly. However, the rule likely only detects the standard
 * @Qualifier annotation, missing this custom variant.
 */
@Configuration
public class S6831_FN {

    /**
     * Custom qualifier annotation, meta-annotated with @Qualifier.
     */
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier // Meta-annotation makes this equivalent to @Qualifier
    public @interface MyQualifier {
        String value() default "";
    }

    @Bean
    @MyQualifier("specialBean") // Likely not flagged — custom annotation not recognized
    public SomeService someService() {
        return new SomeService();
    }
}
