package com.example.springruling.rules.s6816;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * S6816 - False Positive: @Nullable field without @Value (not an injection point).
 *
 * A field annotated with @Nullable but without @Value is not a Spring injection
 * point. It is simply a nullable field. An analyzer might flag the combination
 * of @Nullable without a default, but there is no @Value to inject.
 */
@Component
public class S6816_FP {

    @Nullable // FP - not an injection point, just a nullable field
    private String regularField;

    public void setRegularField(String value) {
        this.regularField = value;
    }

    public String getRegularField() {
        return regularField;
    }
}
