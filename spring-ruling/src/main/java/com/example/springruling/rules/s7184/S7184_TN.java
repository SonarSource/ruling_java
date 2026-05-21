package com.example.springruling.rules.s7184;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * S7184 - True Negative: @Scheduled void method with no parameters.
 *
 * This is the correct signature for a scheduled method.
 * SonarJava should NOT flag this.
 */
@Component
public class S7184_TN {

    @Scheduled(fixedRate = 5000) // Compliant - no parameters
    public void scheduledTask() {
        System.out.println("Running scheduled task");
    }
}
