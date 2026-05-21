package com.example.springruling.rules.s2230;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2230 - True Positive: Private @Transactional method in a @Service class.
 *
 * Spring's proxy-based AOP cannot intercept private methods. The @Transactional
 * annotation on a private method has no effect. SonarJava should flag this.
 */
@Service
public class S2230_TP {

    @Transactional // Noncompliant - private method, proxy cannot intercept
    private void performTransaction() {
        // This method is never proxied, @Transactional has no effect
    }

    public void callTransaction() {
        performTransaction();
    }
}
