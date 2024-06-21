package com.example.demo.controller;

import com.example.demo.entities.Agendamiento;
import com.example.demo.service.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/estudiante/{estudianteId}")
    public List<Agendamiento> listPorEstudiante(@PathVariable int estudianteId) {
        return agendamientoService.listPorEstudiante(estudianteId);
    }

    @GetMapping("/tutor/{tutorId}")
    public List<Agendamiento> listPorTutor(@PathVariable int tutorId) {
        return agendamientoService.listPorTutor(tutorId);
    }

    @PostMapping("/agendar")
    public ResponseEntity<?> agendarCita(@RequestBody Agendamiento agendamiento) {
        try {
            Agendamiento newAgendamiento = agendamientoService.agendarCita(agendamiento);
            return ResponseEntity.ok(newAgendamiento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/borrar/{agendamientoId}")
    public ResponseEntity<String> borrarAgendamiento(@PathVariable int agendamientoId) {
        try {
            Agendamiento deletedAgendamiento = agendamientoService.borrarAgendamiento(agendamientoId);
            if (deletedAgendamiento != null) {
                return ResponseEntity.ok("Agendamiento eliminado correctamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}