package com.uped.JP_BOCCIA_BACK.exception;

public class AuditoriaNoEncontradaException extends RuntimeException {
    public AuditoriaNoEncontradaException(Long id) {
        super("Auditoría con ID " + id + " no fue encontrada.");
    }
}

