package com.example.demo.repositories;
import com.example.demo.entities.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer> {
    List<Agendamiento> findByEstudianteId(int estudianteId);
    List<Agendamiento> findByTutorId(int tutorId);
    List<Agendamiento> findByEstudianteIdAndFechaAndTurno(int estudianteId, Date fecha, int turno);
    List<Agendamiento> findByTutorIdAndFechaAndTurno(int tutorId, Date fecha, int turno);
}
