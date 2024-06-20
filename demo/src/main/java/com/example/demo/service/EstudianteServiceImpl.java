package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Estudiante;
import com.example.demo.repositories.EstudianteRepository;
import java.util.List;

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
    public Estudiante obtenerEstudiantePorCorreo(String correo) {
        return estudianteRepository.findByCorreo(correo);
    }

    @Override
    public Estudiante obtenerEstudiantePorCodigo(String codigo) {
        return estudianteRepository.findByCodigo(codigo);
    }

    @Override
    public Estudiante obtenerEstudiantePorUuid(String uuid) {
        return estudianteRepository.findByUuid(uuid);
    }

    @Override
    public List<Estudiante> listAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante eliminarEstudiantePorCodigo(String codigo) {
        Estudiante estudiante = estudianteRepository.findByCodigo(codigo);
        if (estudiante != null) {
            estudianteRepository.delete(estudiante);
        }
        return estudiante;
    }
    
    @Override
    public Estudiante actualizarEstudiante(int id, String nombre, String correo, String codigo) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setCorreo(correo);
            estudiante.setCodigo(codigo);
            estudianteRepository.save(estudiante);
        }
        return estudiante;
    }

    @Override
    public Estudiante actualizarNombreYCorreo(int id, String nombre, String correo) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setCorreo(correo);
            estudianteRepository.save(estudiante);
        }
        return estudiante;
    }
}