package com.example.demo.service;

import com.example.demo.entities.Agendamiento;
import com.example.demo.entities.Estudiante;
import com.example.demo.repositories.AgendamientoRepository;
import com.example.demo.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamientoServiceImpl implements AgendamientoService {

    @Autowired
    private AgendamientoRepository agendamientoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Agendamiento agendarCita(Agendamiento agendamiento) {
        Estudiante estudiante = estudianteRepository.findById(agendamiento.getEstudiante().getId()).orElse(null);

        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado.");
        }

        // Verificar si el tutor ya está ocupado en la misma fecha y turno
        List<Agendamiento> tutorOccupied = agendamientoRepository.findByTutorIdAndFechaAndTurno(agendamiento.getTutor().getId(), agendamiento.getFecha(), agendamiento.getTurno());
        if (!tutorOccupied.isEmpty()) {
            throw new IllegalArgumentException("El tutor ya está ocupado en esa fecha y turno.");
        }

        // Verificar si el estudiante ya tiene una cita en la misma fecha y turno con otro tutor
        List<Agendamiento> existingAgendamientos = agendamientoRepository.findByEstudianteIdAndFechaAndTurno(estudiante.getId(), agendamiento.getFecha(), agendamiento.getTurno());
        if (!existingAgendamientos.isEmpty()) {
            throw new IllegalArgumentException("Ya tienes agendada una cita en esta fecha y turno con otro tutor.");
        }

        // Si no hay conflictos, proceder a agendar la cita
        agendamiento.setEstudiante(estudiante);
        agendamientoRepository.save(agendamiento);

        return agendamiento;
    }

    @Override
    public Agendamiento borrarAgendamiento(int agendamientoId) {
        Agendamiento agendamiento = agendamientoRepository.findById(agendamientoId).orElse(null);
        if (agendamiento != null) {
            agendamientoRepository.delete(agendamiento);
        }
        return agendamiento;
    }

    @Override
    public List<Agendamiento> listAll() {
        return agendamientoRepository.findAll();
    }

    @Override
    public List<Agendamiento> listPorEstudiante(int estudianteId) {
        return agendamientoRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public List<Agendamiento> listPorTutor(int tutorId) {
        return agendamientoRepository.findByTutorId(tutorId);
    }
}