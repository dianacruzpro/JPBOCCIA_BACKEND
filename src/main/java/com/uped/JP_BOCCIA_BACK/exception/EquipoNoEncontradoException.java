package com.uped.JP_BOCCIA_BACK.exception;

public class EquipoNoEncontradoException extends RuntimeException {
    public EquipoNoEncontradoException(Long id) {
        super("Equipo con ID " + id + " no encontrado.");
    }
}
