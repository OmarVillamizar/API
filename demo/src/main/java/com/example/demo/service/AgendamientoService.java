package com.example.demo.service;

import com.example.demo.entities.Agendamiento;

import java.util.List;

public interface AgendamientoService {
    Agendamiento agendarCita(int agendamientoId, int estudianteId, String motivo, String codigoMateria);
    Agendamiento borrarAgendamiento(int agendamientoId);
    List<Agendamiento> listAll();
    List<Agendamiento> listOcupados();
    List<Agendamiento> listOcupadosPorEstudiante(int estudianteId);
    List<Agendamiento> listOcupadosPorTutor(int tutorId);
    List<Agendamiento> listOcupadosPorEstudianteCodigo(String codigo);
    List<Agendamiento> listOcupadosPorTutorCodigo(String codigo);
}
