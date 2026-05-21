package com.example.springruling.rules.s7184;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * S7184 - False Positive: No-arg @Scheduled method that is also callable with args elsewhere.
 *
 * The method is overloaded: the no-arg version is @Scheduled, and a separate
 * overload accepts arguments for manual invocation. The analyzer should only
 * check the @Scheduled overload (which is correct), but might be confused by
 * the overloaded variant.
 */
@Component
public class S7184_FP {

    @Scheduled(fixedRate = 5000) // Compliant - no-arg overload is correctly @Scheduled
    public void processItems() {
        processItems("default");
    }

    public void processItems(String category) {
        // Callable manually with arguments
        System.out.println("Processing: " + category);
    }
}
