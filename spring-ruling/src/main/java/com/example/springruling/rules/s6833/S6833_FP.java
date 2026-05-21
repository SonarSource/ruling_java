package com.example.springruling.rules.s6833;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * S6833 - False Positive: @Controller with @ResponseBody on only SOME methods,
 * but also a class-level @ResponseBody annotation.
 *
 * In this scenario, the developer applied @ResponseBody at the class level
 * but the controller also has a view-returning method (getPage). The class-level
 * @ResponseBody is arguably incorrect here (it will affect getPage too), but
 * the developer's intent was to have a mix of view and REST endpoints.
 * The rule flags the class-level annotation, but converting to @RestController
 * would also be incorrect for the view-returning method.
 */
@Controller
@ResponseBody // Applied at class level but not all methods should be REST; may still be flagged
public class S6833_FP {

    @GetMapping("/s6833/fp/api/data")
    public String getApiData() {
        return "{\"data\": \"value\"}";
    }

    /**
     * This method is intended to return a view name, but the class-level
     * @ResponseBody forces it to return the string as a response body.
     * The developer's intent is mixed, making the class-level annotation debatable.
     */
    @GetMapping("/s6833/fp/page")
    public String getPage() {
        return "pageName"; // Intended as a view name, but @ResponseBody overrides this
    }
}
