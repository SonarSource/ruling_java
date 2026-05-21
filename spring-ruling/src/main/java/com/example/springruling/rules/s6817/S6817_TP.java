package com.example.springruling.rules.s6817;

import java.util.concurrent.CompletableFuture;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

/**
 * S6817 - True Positive: @Async method in a @Configuration class.
 *
 * @Configuration classes are not intended to have @Async methods. The proxy
 * created for configuration classes is a CGLIB proxy for bean method interception,
 * not for async execution. SonarJava should flag this.
 */
@Configuration
public class S6817_TP {

    @Async // Noncompliant - @Async in @Configuration is problematic
    public CompletableFuture<String> asyncOperation() {
        return CompletableFuture.completedFuture("done");
    }
}
