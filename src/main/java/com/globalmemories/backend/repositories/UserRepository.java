package com.globalmemories.backend.repositories;

import com.globalmemories.backend.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
