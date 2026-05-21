package com.example.springruling.rules.s3749;

import com.example.springruling.shared.ServiceA;
import com.example.springruling.shared.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * S3749 - True Negative: Fields that are properly injected, static, or initialized.
 *
 * All fields in this class are handled correctly:
 * - "serviceA" is @Autowired (injected by Spring)
 * - "appName" is @Value (bound from properties)
 * - "DEFAULT_TIMEOUT" is static (class-level, not instance)
 * - "maxRetries" is final with an initializer
 *
 * SonarJava should NOT flag any of these.
 */
@Service
public class S3749_TN {

    @Autowired
    private ServiceA serviceA; // Compliant - injected

    @Value("${app.name:default}")
    private String appName; // Compliant - bound from properties

    private static final int DEFAULT_TIMEOUT = 30; // Compliant - static

    private final int maxRetries = 3; // Compliant - final with initializer

    private final ServiceB serviceB; // Compliant - set via constructor

    public S3749_TN(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void doWork() {
        serviceA.doWork();
        serviceB.doWork();
    }
}
