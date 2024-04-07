package com.ulas.personnel_tracking_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Work extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String work;

    private String status;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

}
