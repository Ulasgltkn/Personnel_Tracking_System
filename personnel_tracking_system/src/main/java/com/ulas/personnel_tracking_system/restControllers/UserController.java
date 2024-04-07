package com.ulas.personnel_tracking_system.restControllers;

import com.ulas.personnel_tracking_system.entities.Admin;
import com.ulas.personnel_tracking_system.entities.User;
import com.ulas.personnel_tracking_system.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){

        return  userService.saveUser(user);

    }

    @GetMapping("/get/info")
    public ResponseEntity<?> myInfo(@RequestParam int id){

        return  userService.myInfo(id);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updaateUser(@RequestBody User user){

        return userService.updateUser(user);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int id){

        return userService.deleteUser(id);

    }
    @GetMapping("/get")
    public ResponseEntity<?> listAdmin(){

        return  userService.listUser();

    }
    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam String name){

        return  userService.getUser(name);

    }

}
