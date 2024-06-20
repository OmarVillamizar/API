package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Tutor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;
    @Column
    private String correo;
    @Column
    private String codigo;
}