package com.example.springruling.rules.s6832;

import com.example.springruling.shared.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * S6832 - False Positive: Prototype bean injected into a request-scoped bean.
 *
 * This component is itself request-scoped, meaning a new instance is created
 * for each HTTP request. Injecting a prototype bean here is safe because the
 * containing bean also has a short lifecycle. The prototype instance will only
 * be used within a single request. Flagging this would be a false positive.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class S6832_FP {

    @Autowired
    private PrototypeBean prototypeBean; // Potentially flagged, but container is also short-lived

    public void doWork() {
        // Safe: this bean is request-scoped, so the prototype is scoped to the request too
        prototypeBean.execute();
    }
}
