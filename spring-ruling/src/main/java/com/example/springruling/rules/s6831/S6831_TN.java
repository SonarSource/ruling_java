package com.example.springruling.rules.s6831;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * S6831 - True Negative: @Qualifier used at the injection point, not on @Bean.
 *
 * The @Qualifier annotation is correctly used at the injection site (constructor
 * parameter) to disambiguate between multiple beans of the same type. The @Bean
 * method itself has no @Qualifier. SonarJava should NOT flag this.
 */
public class S6831_TN {

    @Configuration
    public static class MyConfig {

        @Bean // Compliant - no @Qualifier on @Bean method
        public SomeService primaryService() {
            return new SomeService();
        }

        @Bean // Compliant - no @Qualifier on @Bean method
        public SomeService secondaryService() {
            return new SomeService();
        }
    }

    @Component
    public static class MyConsumer {

        private final SomeService service;

        @Autowired
        public MyConsumer(@Qualifier("primaryService") SomeService service) { // Compliant - @Qualifier at injection point
            this.service = service;
        }

        public void doWork() {
            service.process();
        }
    }
}
