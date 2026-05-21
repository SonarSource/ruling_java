package com.example.springruling.rules.s4288;

import com.example.springruling.shared.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * S4288 - False Positive: @Autowired setter for optional reconfiguration.
 *
 * This setter is used to allow optional runtime reconfiguration of the
 * dependency. The bean has a default value set in the constructor and the
 * setter exists to allow the container to override it. This is a legitimate
 * use of setter injection for optional/overridable dependencies.
 * Flagging this would be a false positive.
 */
@Component
public class S4288_FP {

    private SomeService someService;

    public S4288_FP() {
        // Default value — works even without injection
        this.someService = null;
    }

    /**
     * Optional setter: allows Spring to override the default if a bean is available.
     * This is a valid pattern for optional reconfiguration.
     */
    @Autowired(required = false)
    public void setSomeService(SomeService someService) { // Potentially flagged, but intentional optional setter
        this.someService = someService;
    }

    public void doWork() {
        if (someService != null) {
            someService.process();
        }
    }
}
