package com.uped.JP_BOCCIA_BACK.service;

import com.uped.JP_BOCCIA_BACK.dto.EquipoDTO;
import java.util.List;

public interface EquipoService {
    List<EquipoDTO> listarEquipos();
    EquipoDTO guardarEquipo(EquipoDTO dto);
    EquipoDTO obtenerEquipoPorId(Long id);
    EquipoDTO actualizarEquipo(Long id, EquipoDTO dto);
    void eliminarEquipo(Long id);
}
