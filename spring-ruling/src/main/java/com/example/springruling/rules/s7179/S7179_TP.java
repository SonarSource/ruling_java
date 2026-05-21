package com.example.springruling.rules.s7179;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S7179 - True Positive: @Cacheable and @CachePut combined on the same method.
 *
 * Using both @Cacheable and @CachePut on the same method leads to contradictory
 * behavior: @Cacheable skips execution if cached, @CachePut always executes and
 * updates the cache. SonarJava should flag this combination.
 */
@Service
public class S7179_TP {

    @Cacheable("items") // Noncompliant - combined with @CachePut
    @CachePut("items")
    public String getItem(Long id) {
        return "item-" + id;
    }
}
