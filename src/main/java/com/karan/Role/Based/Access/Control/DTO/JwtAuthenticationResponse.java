package com.karan.Role.Based.Access.Control.DTO;


public class JwtAuthenticationResponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    private String token;
    private String refreshToken;
}
