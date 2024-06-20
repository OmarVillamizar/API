package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @Column
    private String motivo;

    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalDateTime horaFin;

    @Column(name = "codigo_materia", nullable = false)
    private String codigoMateria;
}