package com.example.springruling.rules.s6816;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * S6816 - True Negative: @Nullable @Value("${prop:default}") with default value.
 *
 * The property placeholder includes a default value after the colon, so even if
 * the property is not defined, Spring will use the default. SonarJava should NOT flag this.
 */
@Component
public class S6816_TN {

    @Nullable
    @Value("${app.optional.property:defaultValue}") // Compliant - default provided
    private String optionalProperty;

    @Nullable
    @Value("${app.optional.number:0}") // Compliant - default provided
    private Integer optionalNumber;
}
