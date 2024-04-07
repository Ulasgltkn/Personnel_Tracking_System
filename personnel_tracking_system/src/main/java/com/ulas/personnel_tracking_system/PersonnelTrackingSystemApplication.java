package com.ulas.personnel_tracking_system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Personel Tracking",version = "1.0",description = "Personel Tracking System"))
public class PersonnelTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelTrackingSystemApplication.class, args);
    }

}
