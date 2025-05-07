package com.uped.JP_BOCCIA_BACK.exception;

public class TorneoNoEncontradoException extends RuntimeException {
    public TorneoNoEncontradoException(Long torneoID) {
        super("El torneo con ID " + torneoID + " no fue encontrado.");
    }
}
