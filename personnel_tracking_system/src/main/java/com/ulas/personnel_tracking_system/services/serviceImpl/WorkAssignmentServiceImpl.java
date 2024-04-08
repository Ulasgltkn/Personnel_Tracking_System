package com.ulas.personnel_tracking_system.services.serviceImpl;

import com.ulas.personnel_tracking_system.entities.User;
import com.ulas.personnel_tracking_system.entities.Work;
import com.ulas.personnel_tracking_system.entities.WorkAssignment;
import com.ulas.personnel_tracking_system.repositories.UserRepository;
import com.ulas.personnel_tracking_system.repositories.WorkAssignmentRepository;
import com.ulas.personnel_tracking_system.repositories.WorkRepository;
import com.ulas.personnel_tracking_system.services.WorkAssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkAssignmentServiceImpl implements WorkAssignmentService {
    private final WorkAssignmentRepository workAssignmentRepository;
    private UserRepository userRepository;


    private WorkRepository workRepository;
    public void assignWorkToUser(int userId, int workId) {
        // Kullanıcı ve iş var mı diye kontrol edelim
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Work> optionalWork = workRepository.findById(workId);

        if (optionalUser.isPresent() && optionalWork.isPresent()) {
            // Kullanıcı ve iş mevcut, atama yapabiliriz
            User user = optionalUser.get();
            Work work = optionalWork.get();

            // Yeni bir iş ataması oluşturup kaydedelim
            WorkAssignment workAssignment = new WorkAssignment();
            workAssignment.setUser(user);
            workAssignment.setWork(work);
            workAssignmentRepository.save(workAssignment);
        } else {
            throw new IllegalArgumentException("User or work not found");
        }
    }

    public List<WorkAssignment> getAssignmentsByUser(Long userId) {
        return workAssignmentRepository.findByUserId(userId);
    }

    public List<WorkAssignment> getAssignmentsByWork(Long workId) {
        return workAssignmentRepository.findByWorkId(workId);
    }
}
