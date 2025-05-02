package com.uped.JP_BOCCIA_BACK.exception;

public class EquipoJugadorNoEncontradoException extends RuntimeException {
    public EquipoJugadorNoEncontradoException(Long id) {
        super("Relación equipo-jugador con ID " + id + " no encontrada.");
    }
}
