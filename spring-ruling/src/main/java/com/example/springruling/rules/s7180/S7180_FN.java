package com.example.springruling.rules.s7180;

import org.springframework.cache.annotation.CacheEvict;

/**
 * S7180 - False Negative: @CacheEvict on abstract class method.
 *
 * An abstract class with @CacheEvict has similar issues as an interface:
 * the cache annotation may not be applied correctly depending on the proxy
 * configuration. The analyzer may only check interfaces and miss abstract classes.
 */
public abstract class S7180_FN {

    @CacheEvict(value = "items", allEntries = true) // FN - cache annotation on abstract method
    public abstract void clearItems();

    public void doWork() {
        // Concrete method
    }
}
