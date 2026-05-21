package com.example.springruling.rules.s6838;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * S6838 - False Positive: proxyBeanMethods=false with @Scope("prototype") beans.
 *
 * When the called @Bean method produces prototype-scoped beans, creating a new
 * instance on each call is the intended behavior. The analyzer might flag the
 * direct @Bean call, but it is correct for prototype scope.
 */
@Configuration(proxyBeanMethods = false)
public class S6838_FP {

    @Bean
    @Scope("prototype")
    public PrototypeService prototypeService() {
        return new PrototypeService();
    }

    @Bean
    public ConsumerService consumerService() {
        // FP - prototype bean, new instance per call is intentional
        return new ConsumerService(prototypeService());
    }

    static class PrototypeService {
    }

    static class ConsumerService {
        private final PrototypeService prototypeService;

        ConsumerService(PrototypeService prototypeService) {
            this.prototypeService = prototypeService;
        }
    }
}
