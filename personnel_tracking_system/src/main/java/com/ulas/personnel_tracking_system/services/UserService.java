package com.ulas.personnel_tracking_system.services;

import com.ulas.personnel_tracking_system.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> myInfo(int id);


    public ResponseEntity<?> saveUser(User user);
    public ResponseEntity<?> updateUser(User user);
    public ResponseEntity<?> deleteUser(int id);
    public ResponseEntity<?> listUser();
    public ResponseEntity<?> getUser(String name);
}
