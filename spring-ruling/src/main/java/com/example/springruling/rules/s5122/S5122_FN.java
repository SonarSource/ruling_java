package com.example.springruling.rules.s5122;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * S5122 - False Negative: CORS configured via a custom servlet filter.
 *
 * Instead of using Spring's @CrossOrigin annotation or CorsConfiguration,
 * this class directly sets the Access-Control-Allow-Origin header to "*"
 * in a custom filter. The analyzer may not detect this as a CORS
 * misconfiguration because it does not use the standard Spring CORS APIs.
 */
@Component
public class S5122_FN implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Wildcard CORS set via raw header - analyzer may not detect this
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(request, response);
    }
}
