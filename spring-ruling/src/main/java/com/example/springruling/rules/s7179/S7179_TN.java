package com.example.springruling.rules.s7179;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S7179 - True Negative: @Cacheable and @CachePut on separate methods.
 *
 * Each annotation is on its own method, which is the correct pattern.
 * SonarJava should NOT flag this.
 */
@Service
public class S7179_TN {

    @Cacheable("items") // Compliant - only @Cacheable
    public String getItem(Long id) {
        return "item-" + id;
    }

    @CachePut("items") // Compliant - only @CachePut
    public String updateItem(Long id, String value) {
        return value;
    }
}
