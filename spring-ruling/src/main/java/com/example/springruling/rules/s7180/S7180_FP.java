package com.example.springruling.rules.s7180;

import com.example.springruling.shared.ItemEntity;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * S7180 - False Positive: @Cacheable on a Spring Data repository interface.
 *
 * Spring Data repository interfaces are handled specially by Spring Data
 * infrastructure, and @Cacheable on their methods works correctly.
 * The analyzer might flag the interface, but this is an accepted pattern.
 */
public interface S7180_FP extends JpaRepository<ItemEntity, Long> {

    @Cacheable("items") // FP - Spring Data repository interface, caching works
    Optional<ItemEntity> findByName(String name);
}
