package com.example.springruling.rules.s3305;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * S3305 - False Positive: @Autowired field in @Configuration used only in non-@Bean methods.
 *
 * The @Autowired field "someService" is NOT used in any @Bean factory method —
 * it is only used in a regular helper method. S3305 targets field injection that
 * is used inside @Bean methods. Flagging this would be a false positive because
 * the field is not participating in bean creation.
 */
@Configuration
public class S3305_FP {

    @Autowired
    private SomeService someService; // Potentially flagged, but only used in non-@Bean method

    /**
     * This is a regular method, not a @Bean factory method.
     * Using @Autowired field here is the same as in any other Spring component.
     */
    public void helperMethod() {
        someService.process();
    }
}
