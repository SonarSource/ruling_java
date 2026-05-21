package com.example.springruling.rules.s7184;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * S7184 - True Positive: @Scheduled method with parameters.
 *
 * @Scheduled methods are invoked by the Spring scheduler without any arguments.
 * A method with parameters cannot be called by the scheduler. SonarJava should flag this.
 */
@Component
public class S7184_TP {

    @Scheduled(fixedRate = 5000) // Noncompliant - method has parameters
    public void scheduledTask(String param) {
        System.out.println("Running with: " + param);
    }
}
