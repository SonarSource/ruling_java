package com.example.springruling.rules.s6862;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6862 - True Negative: @Bean methods with different names.
 *
 * Each @Bean method has a unique name (derived from the method name by default).
 * There is no duplication. SonarJava should NOT flag this.
 */
@Configuration
public class S6862_TN {

    @Bean // Compliant - name is "serviceABean" (from method name)
    public ServiceA serviceABean() {
        return new ServiceA();
    }

    @Bean // Compliant - name is "serviceBBean" (from method name)
    public ServiceB serviceBBean() {
        return new ServiceB();
    }
}
