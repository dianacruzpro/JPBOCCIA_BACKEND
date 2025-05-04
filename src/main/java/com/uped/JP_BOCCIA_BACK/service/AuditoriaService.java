package com.uped.JP_BOCCIA_BACK.service;
import com.uped.JP_BOCCIA_BACK.dto.AuditoriaDTO;

import java.util.List;

public interface AuditoriaService {
    AuditoriaDTO crearAuditoria(AuditoriaDTO auditoriaDTO);
    List<AuditoriaDTO> obtenerTodas();

    AuditoriaDTO actualizarAuditoria(Long id, AuditoriaDTO auditoriaDTO);
    AuditoriaDTO obtenerPorId(Long id);
    void eliminar(Long id);

}

