package com.example.springruling.rules.s6863;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6863 - False Negative: Status code set via HttpServletResponse.setStatus().
 *
 * The status code is set imperatively using HttpServletResponse.setStatus()
 * instead of declaratively via ResponseEntity or @ResponseStatus. The analyzer
 * may not follow the imperative call to determine which status code is actually
 * being set, potentially missing an incorrect status code assignment.
 */
@RestController
public class S6863_FN {

    @PostMapping("/s6863/fn/items")
    public String createItem(@RequestBody String item, HttpServletResponse response) {
        response.setStatus(200); // Incorrect for creation - should be 201; analyzer may miss this
        return "created: " + item;
    }
}
