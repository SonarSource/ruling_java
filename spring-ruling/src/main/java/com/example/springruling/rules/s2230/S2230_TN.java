package com.example.springruling.rules.s2230;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2230 - True Negative: Public @Transactional method in a @Service class.
 *
 * Public methods are properly intercepted by Spring's proxy-based AOP.
 * SonarJava should NOT flag this.
 */
@Service
public class S2230_TN {

    @Transactional // Compliant - public method is properly proxied
    public void performTransaction() {
        // This method is correctly proxied
    }
}
