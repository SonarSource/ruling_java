package com.example.springruling.rules.s7185;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * S7185 - False Positive: @EventListener(classes=X.class) with extra non-event param.
 *
 * The developer specified the event type via the classes attribute and added an
 * extra parameter for context. While technically invalid, the analyzer might flag
 * legitimate multi-parameter patterns. This demonstrates a case where the intent
 * is clear but the signature is wrong.
 */
@Component
public class S7185_FP {

    @EventListener(classes = ContextRefreshedEvent.class) // FP scenario - the extra param is problematic
    public void handleEvent(ContextRefreshedEvent event, String additionalContext) {
        // The additional parameter makes this invalid, but the developer may
        // expect Spring to resolve it. Analyzer flags correctly but developer intent is clear.
        System.out.println("Event: " + event);
    }
}
