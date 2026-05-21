package com.example.springruling.rules.s6838;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6838 - True Positive: Direct @Bean method call with proxyBeanMethods=false.
 *
 * When proxyBeanMethods is false, Spring does not create a CGLIB proxy for the
 * configuration class. Calling a @Bean method directly from another @Bean method
 * creates a new instance each time instead of returning the singleton bean.
 * SonarJava should flag this.
 */
@Configuration(proxyBeanMethods = false)
public class S6838_TP {

    @Bean
    public InnerServiceA serviceA() {
        return new InnerServiceA();
    }

    @Bean
    public InnerServiceB serviceB() {
        // Noncompliant - direct @Bean call creates new instance, not singleton
        return new InnerServiceB(serviceA());
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
