package com.example.springruling.rules.s3749;

import com.example.springruling.shared.SomeService;
import org.springframework.stereotype.Service;

/**
 * S3749 - False Negative: Field populated via XML configuration.
 *
 * The field "someService" has no injection annotation, but is populated
 * at runtime through XML-based Spring configuration (e.g., a bean definition
 * in applicationContext.xml with a <property name="someService" ref="..."/>).
 * Since the analyzer only sees the Java source and not the XML config, it
 * cannot detect that this field is actually wired. The analyzer may either:
 * - Flag it (correct, from a Java-only perspective)
 * - Miss it if it assumes XML config might exist
 *
 * This represents a false negative because the field IS configured but
 * the analyzer cannot verify that from the source code alone.
 */
@Service
public class S3749_FN {

    // This field is intended to be set via XML bean configuration:
    // <bean id="s3749FN" class="...S3749_FN">
    //   <property name="someService" ref="someService"/>
    // </bean>
    private SomeService someService; // May not be flagged if analyzer doesn't see XML

    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    public void doWork() {
        if (someService != null) {
            someService.process();
        }
    }
}
