package com.ulas.personnel_tracking_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surName;
    private String email;
    private String tcNo;
    private String password;
    private int salary;
    private String department;
    private String title;
    private boolean enabled;
    private boolean tokenExpired;




    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "role_Id",referencedColumnName = "id")
    private Role role;





}
