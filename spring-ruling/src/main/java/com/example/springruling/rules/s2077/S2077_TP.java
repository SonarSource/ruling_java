package com.example.springruling.rules.s2077;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * S2077 - True Positive: SQL query with string concatenation using a parameter.
 *
 * The query is built by concatenating a method parameter directly into the SQL string.
 * This is a SQL injection vulnerability. SonarJava should flag this.
 */
@Repository
public class S2077_TP {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public List<Object> findByNameEntityManager(String name) {
        // Noncompliant - SQL injection via string concatenation passed directly
        return entityManager.createNativeQuery("SELECT * FROM app_user WHERE username = '" + name + "'").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object> findByNameEntityManagerVariable(String name) {
        // Noncompliant - SQL injection via string concatenation in variable
        String query = "SELECT * FROM app_user WHERE username = '" + name + "'";
        return entityManager.createNativeQuery(query).getResultList();
    }

    public void findByNameJdbcTemplate(String name) {
        // Noncompliant - SQL injection via string concatenation with JdbcTemplate
        jdbcTemplate.execute("SELECT * FROM app_user WHERE username = '" + name + "'");
    }
}
