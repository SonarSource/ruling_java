package com.example.springruling.rules.s2229;

import java.util.concurrent.Callable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2229 - False Negative: Incompatible call via lambda capturing {@code this}.
 *
 * The lambda captures {@code this} and calls innerMethod() directly (bypassing
 * the proxy), but the indirection through a Callable may prevent the analyzer
 * from detecting the incompatible self-call.
 */
@Service
public class S2229_FN {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void outerMethod() throws Exception {
        // FN - lambda captures this, self-call bypasses proxy but analyzer may miss it
        Callable<Void> task = () -> {
            innerMethod();
            return null;
        };
        task.call();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void innerMethod() {
        // Should run in its own transaction but won't due to proxy bypass
    }
}
