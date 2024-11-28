package com.karan.Role.Based.Access.Control.Service;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

    // Extract the username (subject) from the provided token
    String extractUserName(String token);

    // Generate a new JWT token for the provided user details
    String generateToken(UserDetails userDetails);

    // Validate if the provided token is valid for the given user details
    boolean isTokenValid(String token, UserDetails userDetails);

    // Generate a refresh token with custom claims for the provided user details
    String generateRefreshToken(Map<String, Object> extractClaims, UserDetails userDetails);
}