package com.karan.Role.Based.Access.Control.Service;

import com.karan.Role.Based.Access.Control.DTO.JwtAuthenticationResponse;
import com.karan.Role.Based.Access.Control.DTO.RefreshTokenRequest;
import com.karan.Role.Based.Access.Control.DTO.SignUpRequest;
import com.karan.Role.Based.Access.Control.DTO.SigninRequest;
import com.karan.Role.Based.Access.Control.Model.User;

public interface AuthenticationService {

    // Register a new user with the provided sign-up details
    User signup(SignUpRequest signUpRequest);

    // Authenticate a user and return JWT tokens (access and refresh)
    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    // Generate a new access token using a valid refresh token
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
