package com.example.springruling.rules.s3306;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * S3306 - False Positive: @Autowired on Optional field (optional dependency).
 *
 * The field uses Optional to indicate the dependency is truly optional — it may
 * or may not be present in the application context. Using constructor injection
 * for optional dependencies can be awkward. Flagging this as a violation would
 * be a false positive because Optional fields represent a valid use of field
 * injection for optional dependencies.
 */
@Component
public class S3306_FP {

    @Autowired
    private Optional<SomeService> someService; // Potentially flagged, but this is an optional dependency

    public void doWork() {
        someService.ifPresent(SomeService::process);
    }
}
