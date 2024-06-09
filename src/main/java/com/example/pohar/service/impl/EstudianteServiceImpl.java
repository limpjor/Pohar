package com.example.pohar.service.impl;

import com.example.pohar.exceptions.EstudianteException;
import com.example.pohar.model.Estudiante;
import com.example.pohar.repository.EstudianteRepository;
import com.example.pohar.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante nuevo(Estudiante estudiante) throws EstudianteException{
        estudiante.setId(null);
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtener(Long id) throws EstudianteException{
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        return (estudianteOptional.isPresent()) ? estudianteOptional.get() : new Estudiante();
    }

    @Override
    public Estudiante actualizar(Estudiante estudiante) throws EstudianteException{
        if (Objects.isNull(estudiante.getId()))
            throw new EstudianteException("id no puede ser Null");
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void borrar(Long id) throws EstudianteException{
        estudianteRepository.deleteById(id);
    }
}
