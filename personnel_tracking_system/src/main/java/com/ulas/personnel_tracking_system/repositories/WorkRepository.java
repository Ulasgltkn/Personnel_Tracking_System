package com.ulas.personnel_tracking_system.repositories;

import com.ulas.personnel_tracking_system.entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkRepository extends JpaRepository<Work, Integer> {
    Work findByStatus(String status);

    Optional<Work> findByStatusAndUser_Id(String status, int id);

    Optional<Work> findByUser_Id(int id);

}