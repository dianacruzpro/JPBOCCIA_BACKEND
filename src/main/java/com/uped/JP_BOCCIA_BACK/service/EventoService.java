package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.EventoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Evento;

import java.util.List;

public interface EventoService {
    List<EventoDTO> listarTodos();
    EventoDTO guardar(EventoDTO dto);
    EventoDTO buscarPorId(Long id);
    Evento actualizar(Long id, EventoDTO dto);
    boolean eliminar(Long id);
    List<EventoDTO> guardarVariosEventos(List<EventoDTO> eventos);
}

