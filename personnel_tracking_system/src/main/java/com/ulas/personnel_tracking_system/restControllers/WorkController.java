package com.ulas.personnel_tracking_system.restControllers;

import com.ulas.personnel_tracking_system.entities.Work;
import com.ulas.personnel_tracking_system.services.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final WorkService workService;

 /*   @GetMapping("list/work/{status}")
    public ResponseEntity<?> listWorkStatus(@PathVariable String status){
        return workService.listWorkStatus(status);
    }
    @GetMapping("list/work/{status}/{id}")
    public ResponseEntity<?> listWorkStatusForUser(@PathVariable String status,@PathVariable int id){
        return workService.listWorkStatusForUser(status,id);
    }*/
/*    @GetMapping("list/work/")
    public ResponseEntity<?> listWorkAll(){
        return workService.listWorkAll();
    }
    @GetMapping("list/work/user_id/{id}")
    public ResponseEntity<?> listWorkAllForUser(@PathVariable int id){
        return workService.listWorkAllForUser(id);
    }*/
    @PostMapping("/save")
    public ResponseEntity<?> createWork(@RequestBody Work work){
        return workService.createWork(work);
    }
}
