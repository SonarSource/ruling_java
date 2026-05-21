package com.example.springruling.rules.s6863;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6863 - True Positive: Wrong HTTP status codes in try/catch blocks.
 *
 * The check detects mismatched status codes:
 * - Error/not-found status used in try block (should be success)
 * - Success/ok status used in catch block (should be error)
 * - ResponseEntity.status(HttpStatus.XXX) with wrong category for try vs catch
 *
 * SonarJava should flag these mismatches.
 */
@RestController
public class S6863_TP {

    @GetMapping("/s6863/tp/user")
    public ResponseEntity<String> getUser() {
        try {
            String user = findUser();
            return ResponseEntity.badRequest().build(); // Noncompliant - error status in try block
        } catch (Exception e) {
            return ResponseEntity.ok("fallback"); // Noncompliant - success status in catch block
        }
    }

    @GetMapping("/s6863/tp/item")
    public ResponseEntity<String> getItem() {
        try {
            String item = findItem();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(item); // Noncompliant - error status in try block
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).build(); // Noncompliant - success status in catch block
        }
    }

    @GetMapping("/s6863/tp/resource")
    public ResponseEntity<String> getResource() {
        try {
            String resource = findResource();
            return ResponseEntity.notFound().build(); // Noncompliant - error status in try block
        } catch (Exception e) {
            return ResponseEntity.ok("error fallback"); // Noncompliant - success status in catch block
        }
    }

    private String findUser() {
        return "user";
    }

    private String findItem() {
        return "item";
    }

    private String findResource() {
        return "resource";
    }
}
