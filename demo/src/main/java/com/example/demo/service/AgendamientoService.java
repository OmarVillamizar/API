package com.example.demo.service;

import com.example.demo.entities.Agendamiento;

import java.util.List;

public interface AgendamientoService {

    Agendamiento crearAgendamiento(Agendamiento agendamiento);

    List<Agendamiento> listarAgendamientos();

    Agendamiento actualizarAgendamiento(Agendamiento agendamiento);

    Agendamiento borrarAgendamiento(Integer agendamientoId);
}
