package com.example.springruling.rules.s7177;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 * S7177 - False Negative: @DirtiesContext via meta-annotation.
 *
 * The custom @ResetContext annotation is meta-annotated with @DirtiesContext
 * using AFTER_CLASS. The analyzer may not resolve the meta-annotation chain
 * to detect the problematic class mode.
 */
@S7177_FN.ResetContext // FN - meta-annotation hides @DirtiesContext(AFTER_CLASS)
class S7177_FN {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @DirtiesContext(classMode = ClassMode.AFTER_CLASS)
    @interface ResetContext {
    }

    @Test
    void testOne() {
    }

    @Test
    void testTwo() {
    }
}
