package com.ulas.personnel_tracking_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surName;
    private String email;

    private String password;

    private String title;
    private boolean enabled;
    private boolean tokenExpired;
    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "role_Id", referencedColumnName = "id")
    private Role role;

}
