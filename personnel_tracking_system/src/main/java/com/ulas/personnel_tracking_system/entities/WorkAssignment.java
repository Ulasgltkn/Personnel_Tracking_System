package com.ulas.personnel_tracking_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WorkAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Work work;
    // diğer alanlar, getter ve setter'lar
}
