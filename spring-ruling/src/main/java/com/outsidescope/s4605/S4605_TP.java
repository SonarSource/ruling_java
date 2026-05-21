package com.outsidescope.s4605;

import org.springframework.stereotype.Component;

/**
 * S4605 - True Positive: @Component class outside the scan base package.
 *
 * This class is in com.outsidescope.s4605, which is outside the
 * com.example.springruling package tree scanned by @SpringBootApplication.
 * The bean will not be discovered by component scanning. SonarJava should flag this.
 */
@Component // Noncompliant - outside component scan base package
public class S4605_TP {

    public void doWork() {
        // This bean is unreachable by the default component scan
    }
}
