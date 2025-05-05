package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.PuntuacionDTO;

import java.util.List;

public interface PuntuacionService {
    List<PuntuacionDTO> obtenerTodas();
    PuntuacionDTO obtenerPorId(Long id);
    PuntuacionDTO crear(PuntuacionDTO dto);
    PuntuacionDTO actualizar(Long id, PuntuacionDTO dto);
    void eliminar(Long id);
}
