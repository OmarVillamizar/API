package com.example.demo.service;

import com.example.demo.entities.Agendamiento;

import java.util.List;

public interface AgendamientoService {
    Agendamiento agendarCita(Agendamiento agendamiento);
    Agendamiento borrarAgendamiento(int agendamientoId);
    List<Agendamiento> listAll();
    List<Agendamiento> listPorEstudiante(int estudianteId);
    List<Agendamiento> listPorTutor(int tutorId);
}