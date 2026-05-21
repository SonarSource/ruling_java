package com.example.springruling.rules.s6804;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6804 - False Negative: @Value with constant reference that resolves to a hardcoded string.
 *
 * The constant HARDCODED resolves to a plain string at compile time. The analyzer
 * sees a constant reference in the annotation and may not evaluate it to detect
 * that it resolves to a hardcoded value without ${} or #{}.
 */
@Component
public class S6804_FN {

    private static final String HARDCODED = "myHardcodedValue";

    @Value(HARDCODED) // FN - constant resolves to hardcoded string, analyzer may miss it
    private String value;
}
