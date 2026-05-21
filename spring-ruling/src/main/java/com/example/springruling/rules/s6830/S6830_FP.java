package com.example.springruling.rules.s6830;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S6830 - False Positive: Bean name is a URL or contains dots.
 *
 * Bean names that represent URLs, JNDI names, or fully-qualified class names
 * legitimately contain dots, slashes, or hyphens. These do not follow camelCase
 * but are intentional and meaningful. Flagging them would be a false positive.
 */
@Configuration
public class S6830_FP {

    @Bean("org.example.bean") // Potentially flagged, but this is a FQCN-style name (intentional)
    public SomeService qualifiedNameBean() {
        return new SomeService();
    }

    @Bean("https://example.com/api") // Potentially flagged, but this is a URL identifier (intentional)
    public SomeService urlBean() {
        return new SomeService();
    }
}
