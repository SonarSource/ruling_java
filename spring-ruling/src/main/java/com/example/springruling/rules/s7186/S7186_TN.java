package com.example.springruling.rules.s7186;

import com.example.springruling.shared.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * S7186 - True Negative: Repository with Page return and Pageable parameter.
 *
 * The method correctly accepts a Pageable parameter for pagination.
 * SonarJava should NOT flag this.
 */
public interface S7186_TN extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByEmail(String email, Pageable pageable); // Compliant
}
