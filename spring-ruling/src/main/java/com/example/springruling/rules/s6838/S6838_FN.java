package com.example.springruling.rules.s6838;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6838 - False Negative: Bean method call via this.methodName().
 *
 * The explicit this.serviceA() call is semantically identical to serviceA(),
 * but the analyzer may not detect it as a direct @Bean method invocation
 * when proxyBeanMethods=false.
 */
@Configuration(proxyBeanMethods = false)
public class S6838_FN {

    @Bean
    public InnerServiceA serviceA() {
        return new InnerServiceA();
    }

    @Bean
    public InnerServiceB serviceB() {
        // FN - explicit this. call, still bypasses proxy
        return new InnerServiceB(this.serviceA());
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
