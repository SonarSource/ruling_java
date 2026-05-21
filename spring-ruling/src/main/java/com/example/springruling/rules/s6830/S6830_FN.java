package com.example.springruling.rules.s6830;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * S6830 - False Negative: Bean name registered programmatically.
 *
 * The bean name "BADLY_NAMED_BEAN" is registered via the BeanDefinitionRegistry
 * at runtime. Since the name is constructed programmatically (not via @Bean or
 * @Component annotations), static analysis cannot detect the naming violation.
 */
@Configuration
public class S6830_FN {

    /**
     * Registrar that programmatically registers a bean with a bad name.
     * The analyzer cannot see this name at compile time.
     */
    public static class BadNameRegistrar implements ImportBeanDefinitionRegistrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata metadata,
                                            BeanDefinitionRegistry registry) {
            GenericBeanDefinition beanDef = new GenericBeanDefinition();
            beanDef.setBeanClassName("com.example.springruling.shared.SomeService");
            // Bad name registered programmatically — not visible to static analysis
            registry.registerBeanDefinition("BADLY_NAMED_BEAN", beanDef);
        }
    }
}
