package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.request.AuthenticateRequest;
import com.example.zenrea_backend.dto.response.AuthenticateResponse;
import com.example.zenrea_backend.repository.UserRepo;
import com.example.zenrea_backend.security.JwtService;
import com.example.zenrea_backend.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(), authenticateRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) userRepo.getUserByUsername(authenticateRequest.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticateResponse.builder().token(jwtToken).build();
    }
}
