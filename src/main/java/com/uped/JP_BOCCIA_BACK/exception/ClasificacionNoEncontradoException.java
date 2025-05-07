package com.uped.JP_BOCCIA_BACK.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClasificacionNoEncontradoException extends RuntimeException {
    public ClasificacionNoEncontradoException(Long id) {
        super("No se encontró ninguna clasificación con ID: " + id);
    }
}