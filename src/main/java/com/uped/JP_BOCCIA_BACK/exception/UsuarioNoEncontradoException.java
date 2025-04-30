package com.uped.JP_BOCCIA_BACK.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(Long id) {
        super("Usuario con ID " + id + " no encontrado.");
    }
}