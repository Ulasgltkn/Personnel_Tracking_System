package com.ulas.personnel_tracking_system.repositories;

import com.ulas.personnel_tracking_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);

    void deleteByName(String name);

    Optional<User> findByEmailEqualsIgnoreCase(String username);
}