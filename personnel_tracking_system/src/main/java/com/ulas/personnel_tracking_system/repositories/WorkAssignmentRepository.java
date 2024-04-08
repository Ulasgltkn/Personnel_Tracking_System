package com.ulas.personnel_tracking_system.repositories;

import com.ulas.personnel_tracking_system.entities.WorkAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkAssignmentRepository extends JpaRepository<WorkAssignment, Long> {
    List<WorkAssignment> findByUserId(Long userId);
    List<WorkAssignment> findByWorkId(Long workId);
}