package com.example.springruling.rules.s6863;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6863 - True Negative: @PostMapping returning ResponseEntity with HTTP 201 (Created).
 *
 * The POST endpoint correctly returns HTTP 201 (Created) status code,
 * which is the appropriate response for a resource creation operation.
 * SonarJava should NOT flag this.
 */
@RestController
public class S6863_TN {

    @PostMapping("/s6863/tn/items")
    public ResponseEntity<String> createItem(@RequestBody String item) { // Compliant - returns 201
        return ResponseEntity.status(HttpStatus.CREATED).body("created: " + item);
    }
}
