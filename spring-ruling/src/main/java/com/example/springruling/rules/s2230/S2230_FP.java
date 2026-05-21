package com.example.springruling.rules.s2230;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2230 - False Positive: Protected @Transactional method.
 *
 * Since Spring 6+, protected methods can be proxied when using CGLIB proxies
 * (the default in Spring Boot). An analyzer might flag protected visibility,
 * but it is allowed in modern Spring versions.
 */
@Service
public class S2230_FP {

    @Transactional // Compliant in Spring 6+ with CGLIB proxies
    protected void performTransaction() {
        // Protected methods work with CGLIB proxying in Spring 6+
    }
}
