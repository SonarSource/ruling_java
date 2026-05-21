package com.example.springruling.rules.s3749;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * S3749 - False Positive: Field in a @ConfigurationProperties class.
 *
 * Fields in @ConfigurationProperties classes are bound from external
 * configuration (application.yml / application.properties) via setter or
 * constructor binding. They are not injected via @Autowired or @Value.
 * Flagging these as "not injected" would be a false positive because Spring
 * Boot populates them automatically from configuration properties.
 */
@ConfigurationProperties(prefix = "app.settings")
public class S3749_FP {

    private String hostname; // Potentially flagged, but bound from properties (e.g. app.settings.hostname)
    private int port;        // Potentially flagged, but bound from properties (e.g. app.settings.port)

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
