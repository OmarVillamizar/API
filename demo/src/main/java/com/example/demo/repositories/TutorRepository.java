package com.example.demo.repositories;
import com.example.demo.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {
    Tutor findByCorreo(String correo);
    Tutor findByCodigo(String codigo);
}