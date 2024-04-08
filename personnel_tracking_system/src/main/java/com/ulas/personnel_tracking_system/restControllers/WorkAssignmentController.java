package com.ulas.personnel_tracking_system.restControllers;

import com.ulas.personnel_tracking_system.entities.WorkAssignment;
import com.ulas.personnel_tracking_system.services.WorkAssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@AllArgsConstructor
public class WorkAssignmentController {

    private final WorkAssignmentService workAssignmentService;

    @PostMapping
    public ResponseEntity<?> assignWorkToUser(@RequestParam int userId, @RequestParam int workId) {
        workAssignmentService.assignWorkToUser(userId, workId);
        return ResponseEntity.ok("Work assigned successfully");
    }
    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<WorkAssignment>> getAssignmentsByUser(@PathVariable Long userId) {
        List<WorkAssignment> assignments = workAssignmentService.getAssignmentsByUser(userId);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/byWork/{workId}")
    public ResponseEntity<List<WorkAssignment>> getAssignmentsByWork(@PathVariable Long workId) {
        List<WorkAssignment> assignments = workAssignmentService.getAssignmentsByWork(workId);
        return ResponseEntity.ok(assignments);
    }
}