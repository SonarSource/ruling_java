package com.example.springruling.rules.s6862;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6862 - False Negative: One uses @Bean("name"), the other method is named "name".
 *
 * The first method has an explicit @Bean("myService") name. The second method
 * is named "myService", so its implicit bean name is also "myService". This
 * creates a duplicate bean name situation, but the analyzer may not detect
 * it because one name is explicit and the other is implicit (derived from
 * the method name).
 */
@Configuration
public class S6862_FN {

    @Bean("myService") // Explicit name: "myService"
    public SomeService firstService() {
        return new SomeService();
    }

    @Bean // Implicit name from method name: "myService" — duplicate!
    public SomeService myService() {
        return new SomeService();
    }
}
