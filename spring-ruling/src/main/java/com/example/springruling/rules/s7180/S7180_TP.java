package com.example.springruling.rules.s7180;

import org.springframework.cache.annotation.Cacheable;

/**
 * S7180 - True Positive: Interface with @Cacheable method.
 *
 * Putting @Cacheable on an interface method does not guarantee caching behavior
 * because Spring's proxy-based AOP may not apply to all implementations depending
 * on the proxy mode. SonarJava should flag this.
 */
public interface S7180_TP {

    @Cacheable("items") // Noncompliant - cache annotation on interface method
    String findItem(Long id);
}
