package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.PartidoDTO;

import java.util.List;

public interface PartidoService {

    List<PartidoDTO> listarTodos();
    PartidoDTO guardar(PartidoDTO dto);
    PartidoDTO buscarPorId(Long id);
    PartidoDTO actualizar(Long id, PartidoDTO dto);
    boolean eliminar(Long id);
}
