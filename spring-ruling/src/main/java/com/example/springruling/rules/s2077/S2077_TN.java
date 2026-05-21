package com.example.springruling.rules.s2077;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * S2077 - True Negative: Parameterized query with setParameter.
 *
 * The query uses a named parameter placeholder and setParameter() to bind
 * the value safely. SonarJava should NOT flag this.
 */
@Repository
public class S2077_TN {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Object> findByName(String name) {
        // Compliant - parameterized query
        return entityManager.createNativeQuery("SELECT * FROM app_user WHERE username = :name")
                .setParameter("name", name)
                .getResultList();
    }
}
