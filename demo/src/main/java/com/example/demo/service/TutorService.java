package com.example.demo.service;

import com.example.demo.entities.Tutor;
import java.util.List;

public interface TutorService {
    Tutor guardarTutor(Tutor tutor);
    Tutor obtenerTutorPorId(Integer id);
    Tutor obtenerTutorPorCorreo(String correo);
    Tutor obtenerTutorPorCodigo(String codigo); 
    List<Tutor> listAll();
    Tutor eliminarTutorPorCodigo(String codigo);
    Tutor actualizarTutor(int id, String nombre, String correo, String codigo);  
    Tutor actualizarNombreYCorreo(int id, String nombre, String correo);
}
