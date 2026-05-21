package com.example.springruling.rules.s6831;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6831 - True Positive: @Qualifier used on a @Bean method.
 *
 * The @Qualifier annotation on a @Bean method is redundant because the method
 * name already serves as the bean name/qualifier. Using @Qualifier here is
 * misleading and should be placed at the injection point instead.
 * SonarJava should flag this as a violation of S6831.
 */
@Configuration
public class S6831_TP {

    @Bean
    @Qualifier("myBean") // Noncompliant - @Qualifier should not be on @Bean method
    public SomeService someService() {
        return new SomeService();
    }
}
