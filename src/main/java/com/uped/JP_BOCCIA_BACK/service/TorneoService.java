package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.TorneoDTO;

import java.util.List;

public interface TorneoService {
    List<TorneoDTO> listarTodos();
    TorneoDTO guardar(TorneoDTO torneoDTO);
    TorneoDTO buscarPorId(Long id);
    TorneoDTO actualizar(Long id, TorneoDTO torneoDTO);
    void eliminar(Long id);
}
