package com.example.springruling.rules.s6838;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6838 - True Negative: proxyBeanMethods=true (default) with @Bean inter-call,
 * and proxyBeanMethods=false with parameter injection.
 *
 * With the default proxyBeanMethods=true, direct @Bean calls return singletons.
 * With proxyBeanMethods=false and parameter injection, Spring injects the singleton.
 * SonarJava should NOT flag either pattern.
 */
public class S6838_TN {

    // Case 1: Default proxyBeanMethods=true allows inter-bean calls
    @Configuration
    static class WithProxy {

        @Bean
        public InnerServiceA serviceA() {
            return new InnerServiceA();
        }

        @Bean
        public InnerServiceB serviceB() {
            // Compliant - proxy ensures singleton is returned
            return new InnerServiceB(serviceA());
        }
    }

    // Case 2: proxyBeanMethods=false with parameter injection
    @Configuration(proxyBeanMethods = false)
    static class WithoutProxy {

        @Bean
        public InnerServiceA serviceA() {
            return new InnerServiceA();
        }

        @Bean
        public InnerServiceB serviceB(InnerServiceA serviceA) {
            // Compliant - Spring injects the singleton via parameter
            return new InnerServiceB(serviceA);
        }
    }

    static class InnerServiceA {
    }

    static class InnerServiceB {
        private final InnerServiceA serviceA;

        InnerServiceB(InnerServiceA serviceA) {
            this.serviceA = serviceA;
        }
    }
}
