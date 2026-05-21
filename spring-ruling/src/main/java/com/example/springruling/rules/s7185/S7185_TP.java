package com.example.springruling.rules.s7185;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * S7185 - True Positive: @EventListener method with 2+ parameters.
 *
 * @EventListener methods must have at most one parameter (the event type).
 * Having two or more parameters is invalid. SonarJava should flag this.
 */
@Component
public class S7185_TP {

    @EventListener // Noncompliant - two parameters
    public void handleEvent(ContextRefreshedEvent event, String extra) {
        System.out.println("Event: " + event + ", extra: " + extra);
    }
}
