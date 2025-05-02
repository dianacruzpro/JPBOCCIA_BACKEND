package com.uped.JP_BOCCIA_BACK.exception;

public class JugadorNoEncontradoException extends RuntimeException {
    public JugadorNoEncontradoException(Long id) {
        super("Jugador con ID " + id + " no fue encontrado.");
    }
}
