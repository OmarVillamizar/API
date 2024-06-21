package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "codigo_materia")
    private String codigoMateria;
    
    @Column(name = "fecha")
    private java.sql.Date fecha;

    @Column(name = "turno")
    private int turno;
}