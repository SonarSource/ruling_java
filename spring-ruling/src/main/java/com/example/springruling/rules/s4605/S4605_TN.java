package com.example.springruling.rules.s4605;

import org.springframework.stereotype.Component;

/**
 * S4605 - True Negative: @Component within the scan base package.
 *
 * This class is in com.example.springruling.rules.s4605, which is under the
 * com.example.springruling package tree scanned by @SpringBootApplication.
 * The bean will be discovered by component scanning. SonarJava should NOT flag this.
 */
@Component // Compliant - within component scan base package
public class S4605_TN {

    public void doWork() {
        // This bean is reachable by the default component scan
    }
}
