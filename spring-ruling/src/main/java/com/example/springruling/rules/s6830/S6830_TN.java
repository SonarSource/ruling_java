package com.example.springruling.rules.s6830;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * S6830 - True Negative: Bean names that follow naming conventions.
 *
 * "goodBeanName" and "anotherGoodName" are in camelCase, which is the standard
 * Java naming convention for Spring bean names.
 * SonarJava should NOT flag these.
 */
public class S6830_TN {

    @Component("goodBeanName") // Compliant - camelCase
    public static class GoodComponent {
        public void doWork() { }
    }

    @Configuration
    public static class GoodConfig {

        @Bean("anotherGoodName") // Compliant - camelCase
        public SomeService wellNamedBean() {
            return new SomeService();
        }
    }
}
