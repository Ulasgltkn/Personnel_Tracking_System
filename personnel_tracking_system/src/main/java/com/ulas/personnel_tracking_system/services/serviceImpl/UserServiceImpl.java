package com.ulas.personnel_tracking_system.services.serviceImpl;

import com.ulas.personnel_tracking_system.entities.User;
import com.ulas.personnel_tracking_system.repositories.UserRepository;
import com.ulas.personnel_tracking_system.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> myInfo(int id) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            hashMap.put("status", true);
            hashMap.put("result", user);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
        hashMap.put("status", false);
        hashMap.put("message", "Not Found User");
        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<?> saveUser(User user) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<User> optionalUser = userRepository.findById(user.getId());

        try {
            if (optionalUser.isPresent()) {
                hashMap.put("status", false);
                hashMap.put("message", "Not Save, User is exist");
                return new ResponseEntity<>(hashMap, HttpStatus.ALREADY_REPORTED);
            }
            userRepository.save(user);
            hashMap.put("status", true);
            hashMap.put("result", user);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);

        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<User> optionalAdmin = userRepository.findById(user.getId());
        try {
            if (optionalAdmin.isPresent()) {
                userRepository.saveAndFlush(user);
                hashMap.put("status", true);
                hashMap.put("result", user);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not Found User");
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteUser(int id) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        Optional<User> optionalAdmin = userRepository.findById(id);
        try {
            if (optionalAdmin.isPresent()) {
                userRepository.deleteById(id);
                hashMap.put("status", true);
                hashMap.put("message", "User Deleted");
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not Found User");
            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> listUser() {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        try {
            hashMap.put("result", userRepository.findAll());
            hashMap.put("status", true);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getUser(String email) {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<User> optionalAdmin = userRepository.findByEmail(email);
            if (optionalAdmin.isPresent()) {
                hashMap.put("result", userRepository.findByEmail(email));
                hashMap.put("status", true);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("status", false);
            hashMap.put("message", "Not found User");
            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }
}
