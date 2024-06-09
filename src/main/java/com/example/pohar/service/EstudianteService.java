package com.example.pohar.service;

import com.example.pohar.exceptions.EstudianteException;
import com.example.pohar.model.Estudiante;

public interface EstudianteService {

    Estudiante nuevo(Estudiante estudiante) throws EstudianteException;

    Estudiante obtener(Long id) throws EstudianteException;

    Estudiante actualizar(Estudiante estudiante) throws EstudianteException;

    void borrar(Long id) throws EstudianteException;

}
