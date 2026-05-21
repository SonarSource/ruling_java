package com.example.springruling.rules.s5804;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * S5804 - True Positive: User enumeration via multiple patterns.
 *
 * Pattern 1: setHideUserNotFoundExceptions(false) disables the hiding of
 * UsernameNotFoundException, allowing attackers to distinguish between
 * "user not found" and "wrong password" scenarios.
 *
 * Pattern 2: Throwing UsernameNotFoundException OUTSIDE of loadUserByUsername
 * reveals whether a user exists. Note: throwing it INSIDE loadUserByUsername
 * is considered compliant by the check.
 *
 * Pattern 3: Using the username parameter from loadUserByUsername() in a thrown exception.
 */
@Service
public class S5804_TP {

    public void configureAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        // Noncompliant - disabling the hiding of UsernameNotFoundException allows user enumeration
        authProvider.setHideUserNotFoundExceptions(false);
    }

    public void authenticate(String username, String password) {
        // Noncompliant - throwing UsernameNotFoundException outside of loadUserByUsername
        throw new UsernameNotFoundException("User " + username + " not found");
    }

    public String authenticateWithService(String username, String password) {
        MyUserDetailsService service = new MyUserDetailsService();
        UserDetails user = service.loadUserByUsername(username);
        if (user == null) {
            // Noncompliant - username from loadUserByUsername used in a thrown exception
            throw new RuntimeException(username + " doesn't exist");
        }
        return "authenticated";
    }

    static class MyUserDetailsService implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // Compliant - throwing UsernameNotFoundException inside loadUserByUsername is OK
            return null;
        }
    }
}
