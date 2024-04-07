package com.ulas.personnel_tracking_system.services.serviceImpl;

import com.ulas.personnel_tracking_system.entities.Admin;
import com.ulas.personnel_tracking_system.repositories.AdminRepository;
import com.ulas.personnel_tracking_system.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<?> myInfo(int id) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            hashMap.put("status", true);
            hashMap.put("result", admin);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
        hashMap.put("status", false);
        hashMap.put("message", "Not Found Admin");
        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> saveAdmin(Admin admin) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<Admin> optionalAdmin = adminRepository.findById(admin.getId());

        try {
            if (optionalAdmin.isPresent()) {
                hashMap.put("status", false);
                hashMap.put("message", "Not Save, Admin is exist");
                return new ResponseEntity<>(hashMap, HttpStatus.ALREADY_REPORTED);
            }
            adminRepository.save(admin);
            hashMap.put("status", true);
            hashMap.put("result", admin);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);

        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }


    }

    @Override
    public ResponseEntity<?> updateAdmin(Admin admin) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<Admin> optionalAdmin = adminRepository.findById(admin.getId());
        try {
            if (optionalAdmin.isPresent()) {
                adminRepository.saveAndFlush(admin);
                hashMap.put("status", true);
                hashMap.put("result", admin);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not Found Admin");
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> deleteAdmin(String name) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<Admin> optionalAdmin = adminRepository.findByName(name);
        try {
            if (optionalAdmin.isPresent()) {
                adminRepository.deleteByName(name);
                hashMap.put("status", true);
                hashMap.put("message", "Admin Deleted");
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not Found Admin");
            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }


    @Override
    public ResponseEntity<?> listAdmin() {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        try {
            hashMap.put("result", adminRepository.findAll());
            hashMap.put("status", true);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getAdmin(String name) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Admin> optionalAdmin = adminRepository.findByName(name);
            if (optionalAdmin.isPresent()) {
                hashMap.put("result", adminRepository.findByName(name));
                hashMap.put("status", true);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not found Admin");
            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }


}
