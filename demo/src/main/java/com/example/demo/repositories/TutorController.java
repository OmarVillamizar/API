package com.example.demo.repositories;
import com.example.demo.entities.Tutor;
import com.example.demo.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/{id}")
    public Tutor obtenerTutorPorId(@PathVariable Integer id) {
        return tutorService.obtenerTutorPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public Tutor obtenerTutorPorCodigo(@PathVariable String codigo) {
        return tutorService.obtenerTutorPorCodigo(codigo);
    }

}