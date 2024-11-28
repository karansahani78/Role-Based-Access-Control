package com.karan.Role.Based.Access.Control.Config;

import com.karan.Role.Based.Access.Control.Service.JWTService;
import com.karan.Role.Based.Access.Control.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Get the Authorization header from the HTTP request
        final String authHeader = request.getHeader("Authorization");

        // Variables to store the JWT and user email
        final String jwt;
        final String userEmail;

        // 2. Check if the Authorization header is present and starts with "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response); // If not, continue the filter chain
            return;
        }

        // 3. Extract the JWT from the Authorization header (after "Bearer ")
        jwt = authHeader.substring(7);

        // 4. Extract the username (or email) from the JWT using the JWTService
        userEmail = jwtService.extractUserName(jwt);

        // 5. Check if the username is not null and the user is not already authenticated
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Load the user details from the database
            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);

            // 6. Validate the JWT token
            if (jwtService.isTokenValid(jwt, userDetails)) {

                // Create an empty SecurityContext
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

                // Create a UsernamePasswordAuthenticationToken for the user
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

                // Set additional details for the token (e.g., IP address, session details)
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the SecurityContext
                securityContext.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(securityContext);
            }
        }

        // Continue with the next filter in the chain
        filterChain.doFilter(request, response);
    }
}