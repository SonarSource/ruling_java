package com.example.springruling.rules.s6817;

import java.util.concurrent.CompletableFuture;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

/**
 * S6817 - False Negative: @Async on inherited method in @Configuration.
 *
 * The base class declares the @Async method. The @Configuration subclass inherits
 * it. The analyzer may not detect that the @Async annotation is active in a
 * @Configuration context because it is declared on the parent class.
 */
@Configuration
public class S6817_FN extends S6817_FN_Base {
    // FN - inherits @Async method from base class in @Configuration context
}

abstract class S6817_FN_Base {

    @Async
    public CompletableFuture<String> asyncOperation() {
        return CompletableFuture.completedFuture("done");
    }
}
