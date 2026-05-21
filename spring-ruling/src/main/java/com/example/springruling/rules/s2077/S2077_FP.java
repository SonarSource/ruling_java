package com.example.springruling.rules.s2077;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * S2077 - False Positive: String concatenation with a constant (not user input).
 *
 * The concatenated value is a compile-time constant, not user input. There is no
 * SQL injection risk. The analyzer might flag string concatenation regardless
 * of the source.
 */
@Repository
public class S2077_FP {

    private static final String TABLE_NAME = "app_user";

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Object> findAll() {
        // FP - concatenation with constant, no injection risk
        String query = "SELECT * FROM " + TABLE_NAME;
        return entityManager.createNativeQuery(query).getResultList();
    }
}
