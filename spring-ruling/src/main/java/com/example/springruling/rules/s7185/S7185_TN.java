package com.example.springruling.rules.s7185;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * S7185 - True Negative: @EventListener with 0 or 1 parameters.
 *
 * Both patterns are valid: zero parameters with classes attribute, or one
 * event-type parameter. SonarJava should NOT flag these.
 */
@Component
public class S7185_TN {

    @EventListener // Compliant - one parameter
    public void handleRefresh(ContextRefreshedEvent event) {
        System.out.println("Context refreshed: " + event);
    }

    @EventListener(classes = ContextRefreshedEvent.class) // Compliant - zero parameters
    public void handleRefreshNoParam() {
        System.out.println("Context refreshed");
    }
}
