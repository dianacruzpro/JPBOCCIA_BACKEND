package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.EquipoJugadorDTO;

import java.util.List;

public interface EquipoJugadorService {
    List<EquipoJugadorDTO> listarTodos();
    EquipoJugadorDTO guardar(EquipoJugadorDTO dto);
    EquipoJugadorDTO buscarPorId(Long id);
    void eliminar(Long id);
}