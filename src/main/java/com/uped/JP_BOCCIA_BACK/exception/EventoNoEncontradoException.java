package com.uped.JP_BOCCIA_BACK.exception;

public class EventoNoEncontradoException extends RuntimeException {
  public EventoNoEncontradoException(Long id) {
    super("Evento no encontrado con ID: " + id);
  }
}