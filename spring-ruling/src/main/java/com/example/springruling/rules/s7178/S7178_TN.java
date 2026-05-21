package com.example.springruling.rules.s7178;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S7178 - True Negative: Non-static @Autowired and @Value fields.
 *
 * The @Autowired and @Value annotations are on instance (non-static) fields,
 * which is fully supported by Spring. SonarJava should NOT flag these.
 */
@Component
public class S7178_TN {

    @Autowired
    private SomeService someService; // Compliant - non-static field

    @Value("${app.name:default}")
    private String appName; // Compliant - non-static field

    public void doWork() {
        someService.process();
    }

    public String getAppName() {
        return appName;
    }
}
