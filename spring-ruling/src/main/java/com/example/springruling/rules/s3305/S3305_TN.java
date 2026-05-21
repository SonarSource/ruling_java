package com.example.springruling.rules.s3305;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S3305 - True Negative: @Bean method parameter injection in a @Configuration class.
 *
 * The dependency "someService" is provided as a parameter to the @Bean method,
 * which is the recommended approach for injecting dependencies into factory
 * methods. SonarJava should NOT flag this.
 */
@Configuration
public class S3305_TN {

    @Bean
    public Object myBean(SomeService someService) { // Compliant - parameter injection
        someService.process();
        return someService.create();
    }
}
