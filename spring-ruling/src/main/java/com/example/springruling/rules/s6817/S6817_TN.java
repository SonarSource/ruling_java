package com.example.springruling.rules.s6817;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * S6817 - True Negative: @Async method in a @Service class.
 *
 * @Async is properly supported in @Service (and other @Component) classes where
 * Spring creates an async proxy. SonarJava should NOT flag this.
 */
@Service
public class S6817_TN {

    @Async // Compliant - @Async in @Service is fine
    public CompletableFuture<String> asyncOperation() {
        return CompletableFuture.completedFuture("done");
    }
}
