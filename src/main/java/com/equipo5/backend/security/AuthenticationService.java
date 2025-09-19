package com.equipo5.backend.security;

import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> NoResultsException.of(email));
    }

}