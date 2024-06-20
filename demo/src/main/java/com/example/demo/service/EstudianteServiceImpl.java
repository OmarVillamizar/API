package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Estudiante;
import com.example.demo.repositories.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante obtenerEstudiantePorCorreo(String correo)  	{
        return estudianteRepository.findByCorreo(correo);
    }

    // Otros métodos según sea necesario
}