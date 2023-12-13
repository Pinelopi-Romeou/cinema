package com.example.democinema.authentication;

import com.example.democinema.model.User;
import com.example.democinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private static final String ROLE = "ROLE_";

    @Autowired
    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userRepository.getByUsername(authentication.getName());
        String password = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials");
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), password, Collections.singleton(() -> ROLE + user.getRole().name()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
