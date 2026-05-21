package com.example.springruling.rules.s7178;

import com.example.springruling.shared.SomeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S7178 - False Negative: Static field populated via @PostConstruct setter workaround.
 *
 * The static field "instance" is populated through a @PostConstruct method
 * that copies the injected instance field to the static field. This is a known
 * workaround for static field injection. While it technically works, it has the
 * same problems (global mutable state, testing difficulties). The analyzer may
 * not detect this indirect pattern.
 */
@Component
public class S7178_FN {

    private static SomeService instance; // Not annotated with @Autowired — set via workaround

    @Autowired
    private SomeService someService; // Regular instance injection (compliant)

    @PostConstruct
    private void init() {
        // Workaround: copies instance field to static field
        S7178_FN.instance = this.someService;
    }

    public static void doStaticWork() {
        if (instance != null) {
            instance.process();
        }
    }
}
