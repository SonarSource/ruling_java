package com.example.springruling.rules.s7186;

import org.springframework.data.domain.Page;

/**
 * S7186 - False Positive: Non-repository interface with Page return.
 *
 * This is a plain interface (not a Spring Data repository). The method returns
 * Page but it is not managed by Spring Data, so the Pageable requirement does
 * not apply. The analyzer might flag it based on the return type alone.
 */
public interface S7186_FP {

    Page<?> getResults(String query); // FP - not a Spring Data repository
}
