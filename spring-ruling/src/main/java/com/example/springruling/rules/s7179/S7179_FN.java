package com.example.springruling.rules.s7179;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * S7179 - False Negative: Combined via custom composed annotation.
 *
 * The custom @CacheReadAndWrite annotation combines @Cacheable and @CachePut.
 * The analyzer may not resolve the meta-annotation to detect the conflict.
 */
@Service
public class S7179_FN {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Cacheable("items")
    @CachePut("items")
    @interface CacheReadAndWrite {
    }

    @CacheReadAndWrite // FN - meta-annotation combines @Cacheable and @CachePut
    public String getItem(Long id) {
        return "item-" + id;
    }
}
