package com.example.springruling.rules.s6832;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * S6832 - False Negative: Scope set via @Bean method instead of class annotation.
 *
 * The "scopedViaBean" bean is prototype-scoped, but the scope is defined on the
 * @Bean method rather than on the class itself. The analyzer may not trace the
 * scope from the @Bean definition back to the injection point, causing it to
 * miss that a prototype bean is being injected into a singleton.
 */
public class S6832_FN {

    /**
     * A plain class with no @Scope annotation — scope is set at the @Bean level.
     */
    public static class ScopedViaBean {
        public void execute() { }
    }

    @Configuration
    public static class ScopedConfig {

        @Bean
        @Scope("prototype") // Scope defined here, not on the class
        public ScopedViaBean scopedViaBean() {
            return new ScopedViaBean();
        }
    }

    @Service
    public static class SingletonConsumer {

        @Autowired
        private ScopedViaBean scopedViaBean; // Likely not flagged — scope not visible on the class

        public void doWork() {
            scopedViaBean.execute();
        }
    }
}
