package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.request.AuthenticateRequest;
import com.example.zenrea_backend.dto.response.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
