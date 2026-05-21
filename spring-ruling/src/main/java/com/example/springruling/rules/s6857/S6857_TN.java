package com.example.springruling.rules.s6857;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6857 - True Negative: @Value with valid SpEL expressions.
 *
 * All SpEL expressions here are syntactically correct.
 * SonarJava should NOT flag these.
 */
@Component
public class S6857_TN {

    @Value("#{T(java.lang.Math).random()}")  // Compliant - valid SpEL
    private double randomValue;

    @Value("#{systemProperties['user.name']}") // Compliant - valid SpEL
    private String userName;

    @Value("#{2 + 3}") // Compliant - valid arithmetic SpEL
    private int sum;
}
