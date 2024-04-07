package com.ulas.personnel_tracking_system.repositories;

import com.ulas.personnel_tracking_system.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Override
    Optional<Admin> findById(Integer id);

    Optional<Admin> findByName(String name);

    void deleteByName(String name);

    Optional<Admin> findByEmailEqualsIgnoreCase(String username);
}