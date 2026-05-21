package com.example.springruling.rules.s2230;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * S2230 - False Negative: Private method with custom meta-annotation including @Transactional.
 *
 * The custom annotation @MyTransactional is meta-annotated with @Transactional.
 * A private method annotated with @MyTransactional is still not proxied, but the
 * analyzer may not resolve the meta-annotation chain to detect the issue.
 */
@Service
public class S2230_FN {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Transactional
    @interface MyTransactional {
    }

    @MyTransactional // FN - private method with meta-annotation, proxy cannot intercept
    private void performTransaction() {
        // @Transactional via @MyTransactional is ineffective on private method
    }

    public void callTransaction() {
        performTransaction();
    }
}
