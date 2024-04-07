package com.ulas.personnel_tracking_system.restControllers;

import com.ulas.personnel_tracking_system.entities.Admin;
import com.ulas.personnel_tracking_system.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAdmin(@RequestBody Admin admin){

        return adminService.saveAdmin(admin);

    }
    @GetMapping("/get/info")
    public ResponseEntity<?> myInfo(@RequestParam int id){

        return adminService.myInfo(id);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updaateAdmin(@RequestBody Admin admin){

        return adminService.updateAdmin(admin);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAdmin(@RequestParam String name){

        return adminService.deleteAdmin(name);

    }

    @GetMapping("/get")
    public ResponseEntity<?> listAdmin(){

        return adminService.listAdmin();

    }
    @GetMapping("/getAdmin")
    public ResponseEntity<?> getAdmin(@RequestParam String name){

        return  adminService.getAdmin(name);

    }
}
