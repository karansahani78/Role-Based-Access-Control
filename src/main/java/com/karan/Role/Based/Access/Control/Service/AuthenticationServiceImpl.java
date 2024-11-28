package com.karan.Role.Based.Access.Control.Service;

import com.karan.Role.Based.Access.Control.DTO.JwtAuthenticationResponse;
import com.karan.Role.Based.Access.Control.DTO.RefreshTokenRequest;
import com.karan.Role.Based.Access.Control.DTO.SignUpRequest;
import com.karan.Role.Based.Access.Control.DTO.SigninRequest;
import com.karan.Role.Based.Access.Control.Model.Role;
import com.karan.Role.Based.Access.Control.Model.User;
import com.karan.Role.Based.Access.Control.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository; // Repository for accessing user data
    @Autowired
    private PasswordEncoder passwordEncoder; // Used to encode passwords
    @Autowired
    private AuthenticationManager authenticationManager; // Authenticates user credentials
    @Autowired
    private JWTService jwtService; // Service to handle JWT operations

    // Method to register a new user and save their details
    public User signup(SignUpRequest signUpRequest) {
        User user = new User(); // Create a new user object
        user.setEmail(signUpRequest.getEmail()); // Set user email
        user.setFirstName(signUpRequest.getFirstName()); // Set user first name
        user.setLastName(signUpRequest.getLastName()); // Set user last name
        user.setRole(Role.USER); // Assign the default role to the user
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword())); // Encode the password
        return userRepository.save(user); // Save the user to the database
    }

    // Method to log in a user and generate tokens
    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        // Authenticate the user using email and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getEmail(), signinRequest.getPassword()));

        // Fetch user details from the database
        var user = userRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        // Generate a JWT access token and refresh token
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        // Prepare the response containing the tokens
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt); // Set the access token
        jwtAuthenticationResponse.setRefreshToken(refreshToken); // Set the refresh token
        return jwtAuthenticationResponse;
    }

    // Method to refresh an expired access token using a refresh token
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        // Extract the username (email) from the provided refresh token
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());

        // Fetch user details from the database
        User user = userRepository.findByEmail(userEmail).orElseThrow();

        // Validate the refresh token
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            // Generate a new access token
            var jwt = jwtService.generateToken(user);

            // Prepare the response containing the new token
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt); // Set the new access token
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken()); // Reuse the existing refresh token
            return jwtAuthenticationResponse;
        }
        throw new IllegalArgumentException("Invalid refresh token");
    }
}