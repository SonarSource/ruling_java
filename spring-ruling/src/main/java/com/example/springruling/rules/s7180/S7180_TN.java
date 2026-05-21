package com.example.springruling.rules.s7180;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S7180 - True Negative: @Cacheable on a concrete class method.
 *
 * Cache annotations on concrete class methods work reliably with Spring's
 * proxy-based AOP. SonarJava should NOT flag this.
 */
@Service
public class S7180_TN {

    @Cacheable("items") // Compliant - concrete class method
    public String findItem(Long id) {
        return "item-" + id;
    }
}
