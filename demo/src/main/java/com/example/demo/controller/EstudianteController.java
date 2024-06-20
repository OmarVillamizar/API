package com.example.demo.controller;
import com.example.demo.entities.Estudiante;
import com.example.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/crear")
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.guardarEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable Integer id) {
        return estudianteService.obtenerEstudiantePorId(id);
    }

    @GetMapping("/correo/{correo}")
    public Estudiante obtenerEstudiantePorCorreo(@PathVariable String correo) {
        return estudianteService.obtenerEstudiantePorCorreo(correo);
    }

    // Otros endpoints según sea necesario
}