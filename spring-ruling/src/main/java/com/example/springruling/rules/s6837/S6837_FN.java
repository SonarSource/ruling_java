package com.example.springruling.rules.s6837;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * S6837 - False Negative: Class extending a @RestController base with
 * @ResponseBody on methods.
 *
 * The base class is annotated with @RestController, so all methods in
 * subclasses also inherit the @ResponseBody behavior. Adding @ResponseBody
 * on methods in the subclass is redundant, but the analyzer may not follow
 * the inheritance chain to detect that the parent is a @RestController.
 */
public class S6837_FN extends S6837_FN_Base {

    @GetMapping("/s6837/fn/data")
    @ResponseBody // Redundant - parent class is @RestController; analyzer may miss via inheritance
    public String getData() {
        return "data";
    }
}

/**
 * Base class annotated with @RestController.
 * Subclasses inherit the @RestController semantics.
 */
@RestController
class S6837_FN_Base {
    // Base REST controller - subclasses inherit @ResponseBody behavior
}
