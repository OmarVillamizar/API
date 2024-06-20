package com.example.demo.repositories;
import com.example.demo.entities.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer> {
    List<Agendamiento> findByEstado(int estado);
    List<Agendamiento> findByEstudianteIdAndEstado(int estudianteId, int estado);
    List<Agendamiento> findByTutorIdAndEstado(int tutorId, int estado);
    List<Agendamiento> findByEstudianteCodigoAndEstado(String codigo, int estado);
    List<Agendamiento> findByTutorCodigoAndEstado(String codigo, int estado);
    List<Agendamiento> findByEstudianteIdAndFechaAndTurno(int estudianteId, Date fecha, int turno);
    List<Agendamiento> findByTutorIdAndFechaAndTurnoAndEstado(int tutorId, Date fecha, int turno, int estado);
}
