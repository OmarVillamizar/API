package com.example.demo.repositories;
import com.example.demo.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    Estudiante findByCorreo(String correo);
    Estudiante findByCodigo(String codigo);  // Método para buscar por código
    Estudiante findByUuid(String uuid);      // Método para buscar por uuid
}
