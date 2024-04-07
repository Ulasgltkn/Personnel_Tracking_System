package com.ulas.personnel_tracking_system.services;

import com.ulas.personnel_tracking_system.entities.Work;
import org.springframework.http.ResponseEntity;

public interface WorkService {

    public ResponseEntity<?> listWorkStatusForUser(String status,int id);

    public ResponseEntity<?> listWorkAll();
    public ResponseEntity<?> listWorkAllForUser(int id);
    public ResponseEntity<?> createWork(Work work);
    public ResponseEntity<?> listWorkStatus(String status);
}
