package com.example.demo.controller;

import com.example.demo.entities.Agendamiento;
import com.example.demo.service.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamientos")
public class AgendamientoController {

    @Autowired
    private AgendamientoService agendamientoService;

    @GetMapping("/list")
    public List<Agendamiento> listAllAgendamientos() {
        return agendamientoService.listAll();
    }

    @GetMapping("/ocupados")
    public List<Agendamiento> listOcupados() {
        return agendamientoService.listOcupados();
    }

    @GetMapping("/ocupados/estudiante/{estudianteId}")
    public List<Agendamiento> listOcupadosPorEstudiante(@PathVariable int estudianteId) {
        return agendamientoService.listOcupadosPorEstudiante(estudianteId);
    }

    @GetMapping("/ocupados/tutor/{tutorId}")
    public List<Agendamiento> listOcupadosPorTutor(@PathVariable int tutorId) {
        return agendamientoService.listOcupadosPorTutor(tutorId);
    }

    @GetMapping("/ocupados/estudiante/codigo/{codigo}")
    public List<Agendamiento> listOcupadosPorEstudianteCodigo(@PathVariable String codigo) {
        return agendamientoService.listOcupadosPorEstudianteCodigo(codigo);
    }

    @GetMapping("/ocupados/tutor/codigo/{codigo}")
    public List<Agendamiento> listOcupadosPorTutorCodigo(@PathVariable String codigo) {
        return agendamientoService.listOcupadosPorTutorCodigo(codigo);
    }

    @PutMapping("/agendar/{agendamientoId}")
    public ResponseEntity<?> agendarCita(@PathVariable int agendamientoId, @RequestParam int estudianteId, @RequestParam String motivo, @RequestParam String codigoMateria) {
        try {
            Agendamiento agendamiento = agendamientoService.agendarCita(agendamientoId, estudianteId, motivo, codigoMateria);
            return ResponseEntity.ok(agendamiento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/borrar/{agendamientoId}")
    public Agendamiento borrarAgendamiento(@PathVariable int agendamientoId) {
        return agendamientoService.borrarAgendamiento(agendamientoId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}