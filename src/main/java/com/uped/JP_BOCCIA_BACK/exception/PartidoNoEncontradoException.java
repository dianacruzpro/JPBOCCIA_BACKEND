package com.uped.JP_BOCCIA_BACK.exception;

public class PartidoNoEncontradoException extends RuntimeException {
    public PartidoNoEncontradoException(Long id) {
        super("Partido no encontrado con ID: " + id);
    }
}


