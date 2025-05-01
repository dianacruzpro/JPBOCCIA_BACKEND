package com.uped.JP_BOCCIA_BACK.exception;

public class ArbitroNoEncontradoException extends RuntimeException {
    public ArbitroNoEncontradoException(Long id) {
        super("Árbitro con ID " + id + " no encontrado.");
    }
}
