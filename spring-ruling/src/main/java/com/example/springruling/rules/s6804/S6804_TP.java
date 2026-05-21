package com.example.springruling.rules.s6804;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6804 - True Positive: @Value with a hardcoded string (no ${} or #{}).
 *
 * The @Value annotation should inject a property placeholder or SpEL expression.
 * Using a literal string defeats the purpose of externalized configuration.
 * SonarJava should flag this.
 */
@Component
public class S6804_TP {

    @Value("hardcodedString") // Noncompliant - literal string, not a property or SpEL
    private String appName;

    @Value("some-fixed-value") // Noncompliant - another hardcoded string
    private String fixedValue;
}
