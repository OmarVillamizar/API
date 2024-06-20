package com.example.demo.service;
import com.example.demo.entities.Agendamiento;
import com.example.demo.repositories.AgendamientoRepository;
import com.example.demo.service.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamientoServiceImpl implements AgendamientoService {

    @Autowired
    private AgendamientoRepository agendamientoRepository;

    @Override
    public Agendamiento crearAgendamiento(Agendamiento agendamiento) {
        return agendamientoRepository.save(agendamiento);
    }

    @Override
    public List<Agendamiento> listarAgendamientos() {
        return agendamientoRepository.findAll();
    }

    @Override
    public Agendamiento actualizarAgendamiento(Agendamiento agendamiento) {
        if (agendamiento.getId() != null && agendamientoRepository.existsById(agendamiento.getId())) {
            return agendamientoRepository.save(agendamiento);
        }
        return null; // Opcionalmente lanzar una excepción si no existe
    }

    @Override
    public Agendamiento borrarAgendamiento(Integer agendamientoId) {
        Optional<Agendamiento> agendamientoOptional = agendamientoRepository.findById(agendamientoId);
        if (agendamientoOptional.isPresent()) {
            Agendamiento agendamientoBorrado = agendamientoOptional.get();
            agendamientoRepository.deleteById(agendamientoId);
            return agendamientoBorrado;
        }
        return null; // Opcionalmente lanzar una excepción si no existe
    }
}