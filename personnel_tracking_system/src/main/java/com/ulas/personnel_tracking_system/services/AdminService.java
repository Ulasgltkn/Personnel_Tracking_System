package com.ulas.personnel_tracking_system.services;

import com.ulas.personnel_tracking_system.entities.Admin;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    public ResponseEntity<?> myInfo(int id);

    public ResponseEntity<?> saveAdmin(Admin admin);
    public ResponseEntity<?> updateAdmin(Admin admin);
    public ResponseEntity<?> deleteAdmin(String name);


    public ResponseEntity<?> listAdmin();
    public ResponseEntity<?> getAdmin(String name);




}
