package com.example.springruling.rules.s7178;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * S7178 - False Positive: Static @Autowired field in a non-Spring class.
 *
 * This class is NOT annotated with any Spring stereotype annotation (@Component,
 * @Service, etc.), so it is not managed by Spring. The @Autowired annotation
 * on the static field has no effect regardless. Flagging this would be a false
 * positive because Spring never processes this class for injection.
 */
public class S7178_FP {

    @Autowired
    private static SomeService someService; // Potentially flagged, but class is not a Spring bean

    public static void doWork() {
        if (someService != null) {
            someService.process();
        }
    }
}
