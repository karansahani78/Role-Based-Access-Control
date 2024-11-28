package com.karan.Role.Based.Access.Control.Repository;

import com.karan.Role.Based.Access.Control.Model.Role;
import com.karan.Role.Based.Access.Control.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User>findByEmail(String email);
    public User findByRole(Role role);
}
