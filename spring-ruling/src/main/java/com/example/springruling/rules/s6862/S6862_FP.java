package com.example.springruling.rules.s6862;

import com.example.springruling.shared.SomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * S6862 - False Positive: Same bean name in different @Configuration classes
 * (intentional override).
 *
 * The bean name "sharedBean" appears in two different @Configuration classes,
 * each activated under a different @Profile. This is an intentional override
 * pattern to provide environment-specific implementations. Flagging this
 * would be a false positive because only one profile is active at a time.
 */
public class S6862_FP {

    @Configuration
    @Profile("dev")
    public static class DevConfig {

        @Bean("sharedBean") // Potentially flagged, but only active in "dev" profile
        public SomeService devService() {
            return new SomeService();
        }
    }

    @Configuration
    @Profile("prod")
    public static class ProdConfig {

        @Bean("sharedBean") // Potentially flagged, but only active in "prod" profile
        public SomeService prodService() {
            return new SomeService();
        }
    }
}
