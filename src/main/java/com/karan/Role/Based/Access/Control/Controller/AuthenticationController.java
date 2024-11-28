package com.karan.Role.Based.Access.Control.Controller;


import com.karan.Role.Based.Access.Control.DTO.JwtAuthenticationResponse;
import com.karan.Role.Based.Access.Control.DTO.RefreshTokenRequest;
import com.karan.Role.Based.Access.Control.DTO.SignUpRequest;
import com.karan.Role.Based.Access.Control.DTO.SigninRequest;
import com.karan.Role.Based.Access.Control.Model.User;
import com.karan.Role.Based.Access.Control.Service.AuthenticationService;
import com.karan.Role.Based.Access.Control.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JWTService jwtService;

    // creating a signup api
    @PostMapping("/signup")
    public User signup(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signup(signUpRequest);
    }

    // creating a signin api
    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SigninRequest signinRequest) {
        return authenticationService.signin(signinRequest);
    }

    @PostMapping("/refresh")
    public JwtAuthenticationResponse refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authenticationService.refreshToken(refreshTokenRequest);
    }
}