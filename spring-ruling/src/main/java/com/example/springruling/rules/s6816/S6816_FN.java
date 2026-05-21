package com.example.springruling.rules.s6816;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6816 - False Negative: Using a different nullable annotation (jakarta.annotation.Nullable).
 *
 * The field uses jakarta.annotation.Nullable instead of org.springframework.lang.Nullable.
 * The analyzer may only check for Spring's own @Nullable annotation and miss this
 * alternative nullable indicator.
 */
@Component
public class S6816_FN {

    @jakarta.annotation.Nullable
    @Value("${app.optional.property}") // FN - nullable via jakarta annotation, no default
    private String optionalProperty;
}
