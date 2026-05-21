package com.example.springruling.rules.s6817;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * S6817 - False Positive: @Async in @Configuration that implements AsyncConfigurer.
 *
 * When a @Configuration class implements AsyncConfigurer, it is the canonical way
 * to customize async execution. The @Async method here may be intentional for
 * testing or configuring the async infrastructure. An analyzer might flag it,
 * but this is an accepted Spring pattern.
 */
@Configuration
public class S6817_FP implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, params) -> { /* log error */ };
    }

    @Async // FP - @Configuration with AsyncConfigurer, @Async may be acceptable
    public CompletableFuture<String> asyncOperation() {
        return CompletableFuture.completedFuture("done");
    }
}
