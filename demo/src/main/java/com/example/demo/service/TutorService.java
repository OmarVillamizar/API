package com.example.demo.service;
import com.example.demo.entities.Tutor;

public interface TutorService {
    Tutor guardarTutor(Tutor tutor);
    Tutor obtenerTutorPorId(Integer id);
    Tutor obtenerTutorPorCorreo(String correo);
    Tutor obtenerTutorPorCodigo(String codigo); 
}
