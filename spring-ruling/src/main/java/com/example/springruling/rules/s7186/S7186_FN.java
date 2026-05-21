package com.example.springruling.rules.s7186;

import com.example.springruling.shared.UserEntity;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * S7186 - False Negative: Method returning Slice (which Page extends) without Pageable.
 *
 * Slice also requires a Pageable parameter, but the analyzer may only check
 * for Page return types and miss Slice.
 */
public interface S7186_FN extends JpaRepository<UserEntity, Long> {

    Slice<UserEntity> findByRole(String role); // FN - Slice without Pageable
}
