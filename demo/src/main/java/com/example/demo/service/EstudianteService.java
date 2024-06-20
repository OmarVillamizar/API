package com.example.demo.service;

import com.example.demo.entities.Estudiante;

public interface EstudianteService {
    Estudiante guardarEstudiante(Estudiante estudiante);
    Estudiante obtenerEstudiantePorId(Integer id);
    Estudiante obtenerEstudiantePorCorreo(String correo);
}