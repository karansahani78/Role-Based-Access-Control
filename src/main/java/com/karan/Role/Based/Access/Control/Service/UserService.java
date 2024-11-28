package com.karan.Role.Based.Access.Control.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    // Declares a method to provide a custom UserDetailsService implementation
    UserDetailsService userDetailsService();
}
