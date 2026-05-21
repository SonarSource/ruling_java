package com.example.springruling.rules.s6831;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6831 - False Positive: @Qualifier on @Bean with intentionally different value.
 *
 * The @Qualifier value "customAlias" is intentionally different from the method
 * name "someService". This is a deliberate pattern to give the bean a qualifier
 * that differs from its method-derived name, allowing injection with
 * @Qualifier("customAlias"). While unusual, this is a valid and intentional use.
 * Flagging it would be a false positive.
 */
@Configuration
public class S6831_FP {

    @Bean
    @Qualifier("customAlias") // Potentially flagged, but intentionally different from method name
    public SomeService someService() {
        return new SomeService();
    }
}
