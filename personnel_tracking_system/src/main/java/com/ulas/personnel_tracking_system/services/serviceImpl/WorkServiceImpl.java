package com.ulas.personnel_tracking_system.services.serviceImpl;

import com.ulas.personnel_tracking_system.entities.Work;
import com.ulas.personnel_tracking_system.repositories.WorkRepository;
import com.ulas.personnel_tracking_system.services.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;
    @Override
    public ResponseEntity<?> listWorkStatus(String status) {
        Map<String,Object> hashMap = new HashMap<>();
        Work work = workRepository.findByStatus(status);

        try {
            if (work != null){
                hashMap.put("result",work);
                hashMap.put("status",true);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }
            hashMap.put("message","Not Found " + status + " Work");
            hashMap.put("status",false);
            return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            hashMap.put("status",false);
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

   /* @Override
    public ResponseEntity<?> listWorkStatusForUser(String status, int id) {
        Map<String,Object> hashMap = new LinkedHashMap<>();
        Optional<Work> optionalWork = workRepository.findByStatusAndUser_Id(status,id);
        try {
            if (optionalWork.isPresent()){
                hashMap.put("result",workRepository.findByStatusAndUser_Id(status,id));
                hashMap.put("status",true);
                return new ResponseEntity<>(hashMap,HttpStatus.OK);
            }
            hashMap.put("status",false);
            hashMap.put("message","Not Found Work for User");
            return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            hashMap.put("status",false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }

    }*/




    @Override
    public ResponseEntity<?> listWorkAll() {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        try {
            hashMap.put("result", workRepository.findAll());
            hashMap.put("status", true);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }

  /*  @Override
    public ResponseEntity<?> listWorkAllForUser( int id) {
        Map<String,Object> hashMap = new LinkedHashMap<>();
        Optional<Work> optionalWork = workRepository.findByUser_Id(id);
        try {
            if (optionalWork.isPresent()){
                hashMap.put("result",workRepository.findByUser_Id(id));
                hashMap.put("status",true);
                return new ResponseEntity<>(hashMap,HttpStatus.OK);
            }
            hashMap.put("message","Not found ");
            hashMap.put("status",false);
            return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            hashMap.put("status",false);
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }

    }*/

    @Override
    public ResponseEntity<?> createWork(Work work) {
        Map<String, Object> hashMap = new LinkedHashMap<>();

        Optional<Work> optionalWork = workRepository.findById(work.getId());

        try {
            if (optionalWork.isPresent()) {
                hashMap.put("status", false);
                hashMap.put("message", "Not Save, Work is exist");
                return new ResponseEntity<>(hashMap, HttpStatus.ALREADY_REPORTED);
            }
            workRepository.save(work);
            hashMap.put("status", true);
            hashMap.put("result", work);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);

        } catch (Exception ex) {
            hashMap.put("status", false);
            hashMap.put("message",new Object(){}.getClass().getEnclosingMethod().getName());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }
    }
}
