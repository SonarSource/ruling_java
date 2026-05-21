package com.example.springruling.rules.s6857;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6857 - True Positive: @Value with malformed SpEL expression.
 *
 * The SpEL expression has a syntax error (missing closing parenthesis).
 * SonarJava should flag this as invalid SpEL syntax.
 */
@Component
public class S6857_TP {

    @Value("#{T(java.lang.Math).random(}") // Noncompliant - missing closing parenthesis
    private double randomValue;

    @Value("#{systemProperties['user.name'") // Noncompliant - unclosed bracket
    private String userName;
}
