package com.example.springruling.rules.s7178;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S7178 - True Positive: @Autowired and @Value on static fields.
 *
 * Spring's dependency injection does not support static fields. The @Autowired
 * and @Value annotations on static fields are silently ignored, leaving the
 * fields null (or with default values). This is a common mistake.
 * SonarJava should flag both static fields as violations of S7178.
 */
@Component
public class S7178_TP {

    @Autowired
    private static SomeService someService; // Noncompliant - static field injection not supported

    @Value("${app.name:default}")
    private static String appName; // Noncompliant - static field @Value not supported

    public void doWork() {
        if (someService != null) {
            someService.process();
        }
    }

    public String getAppName() {
        return appName;
    }
}
