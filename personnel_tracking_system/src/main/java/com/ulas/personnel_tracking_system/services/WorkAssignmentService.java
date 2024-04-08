package com.ulas.personnel_tracking_system.services;

import com.ulas.personnel_tracking_system.entities.WorkAssignment;

import java.util.List;

public interface WorkAssignmentService {
    public void assignWorkToUser(int userId, int workId);
    public List<WorkAssignment> getAssignmentsByUser(Long userId);

    public List<WorkAssignment> getAssignmentsByWork(Long workId);
}
