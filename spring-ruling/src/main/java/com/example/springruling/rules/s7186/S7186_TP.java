package com.example.springruling.rules.s7186;

import com.example.springruling.shared.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * S7186 - True Positive: Repository with Page return but no Pageable parameter.
 *
 * A repository method returning Page<> must accept a Pageable parameter so
 * Spring Data can apply pagination. Without it, the query cannot be paginated.
 * SonarJava should flag this.
 */
public interface S7186_TP extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByEmail(String email); // Noncompliant - Page return without Pageable
}
