package com.example.demo.service;
import com.example.demo.entities.Tutor;
import com.example.demo.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    
}
