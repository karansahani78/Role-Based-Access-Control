package com.karan.Role.Based.Access.Control.Service;

import com.karan.Role.Based.Access.Control.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Generates constructor for required fields
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository; // Injects UserRepo for database operations

    // Provides a custom UserDetailsService implementation
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            // Loads user details by username (email) for authentication
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Retrieves user from database or throws an exception if not found
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
