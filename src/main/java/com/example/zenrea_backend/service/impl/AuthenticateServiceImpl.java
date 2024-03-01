package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.request.AuthenticateRequest;
import com.example.zenrea_backend.dto.response.AuthenticateResponse;
import com.example.zenrea_backend.entity.User;
import com.example.zenrea_backend.repository.UserRepo;
import com.example.zenrea_backend.security.JwtService;
import com.example.zenrea_backend.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                        authenticateRequest.getEmail(), authenticateRequest.getPassword()
                )
        );

        User user = userRepo.getUserByUsername(authenticateRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        UserDetails userDetails = user;
        String jwtToken = jwtService.generateToken(userDetails);


        return AuthenticateResponse.builder().token(jwtToken).userId(user.getId()).build();
    }


    // Helper method to generate a random OTP
    private String generateRandomOtp() {
        // Implement your logic to generate a random OTP (e.g., using SecureRandom)
        // This is a simplified example; you might want to use a library for OTP generation
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }

}