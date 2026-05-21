package com.example.springruling.rules.s6832;

import com.example.springruling.shared.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * S6832 - True Positive: Prototype-scoped bean injected into a singleton.
 *
 * The @Service annotation implies singleton scope. The PrototypeBean is
 * prototype-scoped (@Scope("prototype")), but when it is directly @Autowired
 * into a singleton, only one instance is created and reused for the entire
 * lifetime of the singleton. This defeats the purpose of prototype scope.
 * SonarJava should flag this as a violation of S6832.
 */
@Service
public class S6832_TP {

    @Autowired
    private PrototypeBean prototypeBean; // Noncompliant - prototype injected into singleton

    public void doWork() {
        // This always uses the same instance of PrototypeBean,
        // even though it is prototype-scoped
        prototypeBean.execute();
    }
}
