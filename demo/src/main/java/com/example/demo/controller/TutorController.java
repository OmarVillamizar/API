package com.example.demo.controller;
import com.example.demo.entities.Tutor;
import com.example.demo.service.TutorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;
    
    @GetMapping("/list")
    public List<Tutor> listAllTutores() {
        return tutorService.listAll();
    }

    @GetMapping("/{id}")
    public Tutor obtenerTutorPorId(@PathVariable Integer id) {
        return tutorService.obtenerTutorPorId(id);
    }
    
    @PostMapping("/crear")
    public Tutor crearTutor(@RequestBody Tutor tutor) {
        return tutorService.guardarTutor(tutor);
    }

    @GetMapping("/codigo/{codigo}")
    public Tutor obtenerTutorPorCodigo(@PathVariable String codigo) {
        return tutorService.obtenerTutorPorCodigo(codigo);
    }
    
    @DeleteMapping("/delete")
    public Tutor eliminarTutorPorCodigo(@RequestParam String codigo) {
        return tutorService.eliminarTutorPorCodigo(codigo);
    }
    
    @PutMapping("/actualizar")
    public Tutor actualizarTutor(@RequestBody Tutor tutor) {
        return tutorService.actualizarTutor(tutor);
    }
}