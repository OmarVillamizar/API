package com.example.demo.repositories;

import com.example.demo.entities.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer> {
    // Puedes agregar métodos adicionales según necesites
}
