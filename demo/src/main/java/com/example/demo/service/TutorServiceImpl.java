package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Tutor;
import com.example.demo.repositories.TutorRepository;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Tutor guardarTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor obtenerTutorPorId(Integer id) {
        return tutorRepository.findById(id).orElse(null);
    }

    @Override
    public Tutor obtenerTutorPorCorreo(String correo) {
        return tutorRepository.findByCorreo(correo);
    }

    @Override
    public Tutor obtenerTutorPorCodigo(String codigo) {
        return tutorRepository.findByCodigo(codigo);
    }

    @Override
    public List<Tutor> listAll() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor eliminarTutorPorCodigo(String codigo) {
        Tutor tutor = tutorRepository.findByCodigo(codigo);
        if (tutor != null) {
            tutorRepository.delete(tutor);
        }
        return tutor;
    }

    @Override
    public Tutor actualizarTutor(Tutor tutor) {
        if (tutorRepository.existsById(tutor.getId())) {
            return tutorRepository.save(tutor);
        }
        return null;  
    }
}