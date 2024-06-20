package com.example.demo.controller;

import com.example.demo.entities.Agendamiento;
import com.example.demo.service.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamientos")
public class AgendamientoController {

    @Autowired
    private AgendamientoService agendamientoService;

    @PostMapping
    public ResponseEntity<Agendamiento> crearAgendamiento(@RequestBody Agendamiento agendamiento) {
        Agendamiento nuevoAgendamiento = agendamientoService.crearAgendamiento(agendamiento);
        return new ResponseEntity<>(nuevoAgendamiento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agendamiento>> listarAgendamientos() {
        List<Agendamiento> agendamientos = agendamientoService.listarAgendamientos();
        return new ResponseEntity<>(agendamientos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamiento> actualizarAgendamiento(@PathVariable Integer id, @RequestBody Agendamiento agendamiento) {
        agendamiento.setId(id);
        Agendamiento agendamientoActualizado = agendamientoService.actualizarAgendamiento(agendamiento);
        if (agendamientoActualizado != null) {
            return new ResponseEntity<>(agendamientoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agendamiento> borrarAgendamiento(@PathVariable Integer id) {
        Agendamiento agendamientoBorrado = agendamientoService.borrarAgendamiento(id);
        if (agendamientoBorrado != null) {
            return new ResponseEntity<>(agendamientoBorrado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
