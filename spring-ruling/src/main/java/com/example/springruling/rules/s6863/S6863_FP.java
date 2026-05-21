package com.example.springruling.rules.s6863;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6863 - False Positive: POST endpoint that is idempotent and intentionally returns 200.
 *
 * Not all POST endpoints create resources. This endpoint performs an idempotent
 * operation (e.g., a search or a calculation) where returning 200 (OK) is
 * appropriate. The rule may still flag it because it is a POST returning 200,
 * but in this case the 200 status code is intentional and correct.
 */
@RestController
public class S6863_FP {

    /**
     * POST endpoint used for a search operation (not a creation).
     * Returning 200 is correct here because no resource is being created.
     */
    @PostMapping("/s6863/fp/search")
    public ResponseEntity<String> search(@RequestBody String query) { // POST returning 200 intentionally - not a creation
        String result = "results for: " + query;
        return ResponseEntity.ok(result); // 200 is appropriate for search
    }
}
