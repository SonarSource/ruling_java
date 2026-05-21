package com.example.springruling.rules.s5804;

import com.example.springruling.shared.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * S5804 - False Positive: UserDetailsService that throws generic message.
 *
 * This implementation throws UsernameNotFoundException with a completely generic
 * message that does not reveal whether the username exists. However, the analyzer
 * may still flag it simply because it throws UsernameNotFoundException, even
 * though the message content does not leak user-specific information.
 */
@Service
public class S5804_FP implements UserDetailsService {

    private final UserRepository userRepository;

    public S5804_FP(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var page = userRepository.findByUsername(username, PageRequest.of(0, 1));
        if (page.isEmpty()) {
            // Generic message - does not reveal whether the username exists
            // Analyzer may still flag because it throws UsernameNotFoundException
            throw new UsernameNotFoundException("Authentication failed");
        }
        var entity = page.getContent().get(0);
        return User.withUsername(entity.getUsername())
            .password(entity.getPassword())
            .roles(entity.getRole())
            .build();
    }
}
