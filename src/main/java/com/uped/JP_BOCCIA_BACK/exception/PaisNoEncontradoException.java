package com.uped.JP_BOCCIA_BACK.exception;

public class PaisNoEncontradoException extends RuntimeException {
  public PaisNoEncontradoException(Long id) {
    super("País con ID " + id + " no encontrado.");
  }
}
