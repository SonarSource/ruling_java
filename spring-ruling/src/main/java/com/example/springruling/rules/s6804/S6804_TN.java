package com.example.springruling.rules.s6804;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6804 - True Negative: @Value with property placeholder and SpEL expression.
 *
 * Both ${} property placeholders and #{} SpEL expressions are valid uses of @Value.
 * SonarJava should NOT flag these.
 */
@Component
public class S6804_TN {

    @Value("${app.name}") // Compliant - property placeholder
    private String appName;

    @Value("#{systemProperties['user.name']}") // Compliant - SpEL expression
    private String userName;

    @Value("${app.timeout:30}") // Compliant - property with default
    private int timeout;
}
