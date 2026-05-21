package com.example.springruling.rules.s7185;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * S7185 - False Negative: @EventListener with Object... varargs.
 *
 * The method has a varargs parameter which is effectively an array parameter.
 * Spring cannot invoke this correctly, but the analyzer may treat varargs
 * as compatible with zero-argument invocation and miss the issue.
 */
@Component
public class S7185_FN {

    @EventListener // FN - varargs is still a parameter, Spring cannot resolve it
    public void handleEvent(Object... events) {
        for (Object event : events) {
            System.out.println("Event: " + event);
        }
    }
}
