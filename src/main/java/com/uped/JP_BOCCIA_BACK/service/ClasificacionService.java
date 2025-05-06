package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.ClasificacionDTO;

import java.util.List;

public interface ClasificacionService {
    List<ClasificacionDTO> listarTodos();
    ClasificacionDTO guardar(ClasificacionDTO dto);
    ClasificacionDTO buscarPorId(Long id);
    ClasificacionDTO actualizar(ClasificacionDTO dto);
    void eliminar(Long id);
}