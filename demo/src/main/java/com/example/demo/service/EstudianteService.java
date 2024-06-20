package com.example.demo.service;

import com.example.demo.entities.Estudiante;
import java.util.List;

public interface EstudianteService {
    Estudiante guardarEstudiante(Estudiante estudiante);
    Estudiante obtenerEstudiantePorId(Integer id);
    Estudiante obtenerEstudiantePorCorreo(String correo);
    Estudiante obtenerEstudiantePorCodigo(String codigo);
    Estudiante obtenerEstudiantePorUuid(String uuid);
    List<Estudiante> listAll();
    Estudiante eliminarEstudiantePorCodigo(String codigo);
}
