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
    public Agendamiento agendarCita(int agendamientoId, int estudianteId, String motivo, String codigoMateria) {
        Agendamiento agendamiento = agendamientoRepository.findById(agendamientoId).orElse(null);
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElse(null);

        if (agendamiento != null && estudiante != null && agendamiento.getEstado() == 0) {
            // Verificar si el tutor ya está ocupado en el mismo turno y día
            List<Agendamiento> tutorOccupied = agendamientoRepository.findByTutorIdAndFechaAndTurnoAndEstado(agendamiento.getTutor().getId(), agendamiento.getFecha(), agendamiento.getTurno(), 1);

            if (!tutorOccupied.isEmpty()) {
                throw new IllegalArgumentException("El tutor está ocupado en este turno y fecha.");
            }

            // Verificar si el estudiante ya tiene una cita en el mismo turno y día
            List<Agendamiento> existingAgendamientos = agendamientoRepository.findByEstudianteIdAndFechaAndTurno(estudianteId, agendamiento.getFecha(), agendamiento.getTurno());
            if (!existingAgendamientos.isEmpty()) {
                throw new IllegalArgumentException("El estudiante ya tiene una cita en el mismo turno y día.");
            }

            // Si no hay conflictos, proceder a agendar la cita
            agendamiento.setEstudiante(estudiante);
            agendamiento.setMotivo(motivo);
            agendamiento.setCodigoMateria(codigoMateria);
            agendamiento.setEstado(1); // Cambia el estado a ocupado
            agendamientoRepository.save(agendamiento);
        }
        return agendamiento;
    }

    @Override
    public Agendamiento borrarAgendamiento(int agendamientoId) {
        Agendamiento agendamiento = agendamientoRepository.findById(agendamientoId).orElse(null);
        if (agendamiento != null && agendamiento.getEstado() == 1) {
            agendamiento.setEstudiante(null);
            agendamiento.setMotivo(null);
            agendamiento.setCodigoMateria(null);
            agendamiento.setEstado(0); // Cambia el estado a libre
            agendamientoRepository.save(agendamiento);
        }
        return agendamiento;
    }

    @Override
    public List<Agendamiento> listAll() {
        return agendamientoRepository.findAll();
    }

    @Override
    public List<Agendamiento> listOcupados() {
        return agendamientoRepository.findByEstado(1);
    }

    @Override
    public List<Agendamiento> listOcupadosPorEstudiante(int estudianteId) {
        return agendamientoRepository.findByEstudianteIdAndEstado(estudianteId, 1);
    }

    @Override
    public List<Agendamiento> listOcupadosPorTutor(int tutorId) {
        return agendamientoRepository.findByTutorIdAndEstado(tutorId, 1);
    }

    @Override
    public List<Agendamiento> listOcupadosPorEstudianteCodigo(String codigo) {
        return agendamientoRepository.findByEstudianteCodigoAndEstado(codigo, 1);
    }

    @Override
    public List<Agendamiento> listOcupadosPorTutorCodigo(String codigo) {
        return agendamientoRepository.findByTutorCodigoAndEstado(codigo, 1);
    }
}