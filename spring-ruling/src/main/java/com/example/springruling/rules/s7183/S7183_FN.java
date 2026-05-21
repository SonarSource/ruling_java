package com.example.springruling.rules.s7183;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * S7183 - False Negative: @InitBinder method returning Object.
 *
 * The method returns Object instead of void. Like returning String, this is
 * incorrect because @InitBinder methods must return void. However, the analyzer
 * may only check for specific return types (like String) and miss Object.
 */
@Controller
public class S7183_FN {

    @InitBinder // Noncompliant - returns Object instead of void; analyzer may only check String
    public Object initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        return new Object(); // Return value is ignored by Spring - this is a mistake
    }
}
