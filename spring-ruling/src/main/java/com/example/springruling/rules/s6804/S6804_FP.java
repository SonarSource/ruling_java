package com.example.springruling.rules.s6804;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S6804 - False Positive: @Value("classpath:schema.sql") looks like a resource reference.
 *
 * Although the string doesn't contain ${} or #{}, it is a valid Spring resource
 * path pattern. The analyzer might flag it as a hardcoded string, but it is an
 * accepted Spring convention for resource references.
 */
@Component
public class S6804_FP {

    @Value("classpath:schema.sql") // FP - resource reference pattern, not a simple hardcoded string
    private org.springframework.core.io.Resource schemaResource;

    @Value("classpath:data/*.csv") // FP - resource pattern
    private org.springframework.core.io.Resource[] dataFiles;
}
