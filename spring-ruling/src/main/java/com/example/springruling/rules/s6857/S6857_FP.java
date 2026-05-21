package com.example.springruling.rules.s6857;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6857 - False Positive: Complex SpEL with custom function that the analyzer may
 * not resolve.
 *
 * The SpEL references a custom-registered function. The syntax is valid, but the
 * analyzer may report it as invalid because it cannot resolve the custom function.
 */
@Component
public class S6857_FP {

    @Value("#{@myCustomBean.computeValue('input')}") // FP - valid SpEL referencing a bean
    private String computedValue;
}
