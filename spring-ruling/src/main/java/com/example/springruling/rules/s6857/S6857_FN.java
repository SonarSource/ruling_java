package com.example.springruling.rules.s6857;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S6857 - False Negative: Malformed SpEL in @Cacheable key.
 *
 * The SpEL expression in the @Cacheable key attribute has a syntax error.
 * The analyzer may only check @Value annotations and miss SpEL in other
 * Spring annotations like @Cacheable.
 */
@Service
public class S6857_FN {

    @Cacheable(value = "items", key = "#id.toString(") // FN - malformed SpEL in @Cacheable key
    public String findItem(Long id) {
        return "item-" + id;
    }
}
