package com.example.pohar.controller;

import com.example.pohar.exceptions.EstudianteException;
import com.example.pohar.model.Estudiante;
import com.example.pohar.service.EstudianteService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Estudiante", tags = {"Estudiante."}, description = "Modulo para administrar Estudiantes.")
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    private static final Logger log = LoggerFactory.getLogger(EstudianteController.class);

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @ApiOperation(value = "Crear Estudiante", response = Estudiante.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Estudiante creado correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PostMapping("/nuevo")
    public ResponseEntity<Estudiante> nuevo(
            @ApiParam(value = "Estudiante a crear", required = true)
            @RequestBody @Valid Estudiante estudiante) {
        try {
            Estudiante nuevoEstudiante = estudianteService.nuevo(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
        } catch (EstudianteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Obtener Estudiante mediante un id", response = Estudiante.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Estudiante encontrado", response = Estudiante.class),
            @ApiResponse(code = 404, message = "Estudiante no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @GetMapping("")
    public ResponseEntity<Estudiante> obtener(
            @ApiParam(value = "ID del estudiante a obtener", required = true)
            @RequestParam Long id) {
        try {
            Estudiante estudiante = estudianteService.obtener(id);
            return ResponseEntity.ok(estudiante);
        } catch (EstudianteException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "Actualizar datos del Estudiante", response = Estudiante.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Estudiante actualizado correctamente", response = Estudiante.class),
            @ApiResponse(code = 400, message = "Error en la solicitud"),
            @ApiResponse(code = 404, message = "Estudiante no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PostMapping("/actualizar")
    public ResponseEntity<Estudiante> actualizar(
            @ApiParam(value = "Estudiante a actualizar", required = true)
            @RequestBody @Valid Estudiante estudiante) {
        try {
            Estudiante nuevoEstudiante = estudianteService.actualizar(estudiante);
            return ResponseEntity.status(HttpStatus.OK).body(nuevoEstudiante);
        } catch (EstudianteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Eliminar Estudiante mediante un id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Estudiante eliminado correctamente"),
            @ApiResponse(code = 404, message = "Estudiante no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @DeleteMapping("")
    public ResponseEntity<Void> borrar(
            @ApiParam(value = "ID del estudiante a eliminar", required = true)
            @RequestParam Long id) {
        try {
            estudianteService.borrar(id);
            return ResponseEntity.noContent().build();
        } catch (EstudianteException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
