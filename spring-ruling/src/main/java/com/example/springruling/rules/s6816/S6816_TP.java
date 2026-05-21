package com.example.springruling.rules.s6816;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * S6816 - True Positive: @Nullable @Value("${prop}") without default value.
 *
 * When a field is annotated with @Nullable and @Value without a default value,
 * the application may fail at runtime if the property is not defined. A default
 * should be provided. SonarJava should flag this.
 */
@Component
public class S6816_TP {

    @Nullable
    @Value("${app.optional.property}") // Noncompliant - no default for nullable field
    private String optionalProperty;
}
