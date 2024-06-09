package com.example.pohar.exceptions;

public class EstudianteException extends RuntimeException {

    public EstudianteException(String message) {
        super(message);
    }

    public EstudianteException(String message, Throwable cause) {
        super(message, cause);
    }
}

