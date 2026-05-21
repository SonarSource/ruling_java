package com.example.springruling.rules.s6832;

import com.example.springruling.shared.PrototypeBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * S6832 - True Negative: Prototype bean accessed via ObjectProvider.
 *
 * Instead of directly injecting the prototype bean, this singleton uses
 * ObjectProvider<PrototypeBean>, which creates a new instance on each call
 * to getObject(). This correctly preserves the prototype semantics.
 * SonarJava should NOT flag this.
 */
@Service
public class S6832_TN {

    private final ObjectProvider<PrototypeBean> prototypeBeanProvider; // Compliant - uses ObjectProvider

    public S6832_TN(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
        this.prototypeBeanProvider = prototypeBeanProvider;
    }

    public void doWork() {
        // Each call creates a fresh prototype instance
        PrototypeBean freshInstance = prototypeBeanProvider.getObject();
        freshInstance.execute();
    }
}
