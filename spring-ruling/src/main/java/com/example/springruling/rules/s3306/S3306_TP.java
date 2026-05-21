package com.example.springruling.rules.s3306;

import com.example.springruling.shared.SomeService;
import javax.inject.Inject;

/**
 * S3306 - True Positive: @Inject field injection instead of constructor injection.
 *
 * The field "someService" is injected using @javax.inject.Inject field injection.
 * Best practices recommend constructor injection instead, as it ensures
 * immutability, makes dependencies explicit, and supports testing.
 * SonarJava should flag this as a violation of S3306.
 *
 * Note: The check specifically looks for javax.inject.Inject, NOT @Autowired.
 */
public class S3306_TP {

    @Inject
    Object someService; // Noncompliant - field injection should be constructor injection

    public void doWork() {
        someService.toString();
    }
}
