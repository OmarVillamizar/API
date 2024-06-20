package com.example.demo.controller;

import com.example.demo.entities.Estudiante;
import com.example.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/codigo/{codigo}")
    public Estudiante obtenerEstudiantePorCodigo(@PathVariable String codigo) {
        return estudianteService.obtenerEstudiantePorCodigo(codigo);
    }

    @GetMapping("/uuid/{uuid}")
    public Estudiante obtenerEstudiantePorUuid(@PathVariable String uuid) {
        return estudianteService.obtenerEstudiantePorUuid(uuid);
    }

    @GetMapping("/list")
    public List<Estudiante> listAllEstudiantes() {
        return estudianteService.listAll();
    }

    @DeleteMapping("/delete")
    public Estudiante eliminarEstudiantePorCodigo(@RequestParam String codigo) {
        return estudianteService.eliminarEstudiantePorCodigo(codigo);
    }
}