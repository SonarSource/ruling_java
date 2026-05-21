package com.example.springruling.rules.s2077;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * S2077 - False Negative: Query string built in a helper method then passed to createNativeQuery.
 *
 * The SQL injection happens in buildQuery(), but the concatenated string is passed
 * to createNativeQuery() indirectly. The analyzer may not trace the tainted value
 * through the helper method.
 */
@Repository
public class S2077_FN {

    @PersistenceContext
    private EntityManager entityManager;

    private String buildQuery(String username) {
        return "SELECT * FROM app_user WHERE username = '" + username + "'";
    }

    @SuppressWarnings("unchecked")
    public List<Object> findByName(String name) {
        // FN - tainted string comes from helper method
        String query = buildQuery(name);
        return entityManager.createNativeQuery(query).getResultList();
    }
}
