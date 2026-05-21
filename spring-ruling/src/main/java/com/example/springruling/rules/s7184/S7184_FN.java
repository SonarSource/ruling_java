package com.example.springruling.rules.s7184;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * S7184 - False Negative: @Scheduled on method with varargs.
 *
 * Varargs methods technically have a parameter (an array), so the scheduler
 * cannot invoke them. The analyzer may treat varargs as "no arguments" and
 * miss this violation.
 */
@Component
public class S7184_FN {

    @Scheduled(fixedRate = 5000) // FN - varargs is still a parameter
    public void scheduledTask(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
