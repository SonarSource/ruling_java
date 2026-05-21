package com.example.springruling.rules.s7179;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S7179 - False Positive: @Cacheable and @CachePut on same method but different caches.
 *
 * When @Cacheable and @CachePut target different cache names, the developer may
 * intentionally want to read from one cache and write to another. The analyzer
 * might flag the combination, but this could be a valid multi-cache pattern.
 */
@Service
public class S7179_FP {

    @Cacheable("readCache")  // FP - different caches may be intentional
    @CachePut("writeCache")
    public String getAndUpdateItem(Long id) {
        return "item-" + id;
    }
}
