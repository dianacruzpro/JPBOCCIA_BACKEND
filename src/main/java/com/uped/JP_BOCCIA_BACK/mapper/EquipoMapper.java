package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.EquipoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;
import com.uped.JP_BOCCIA_BACK.entity.Pais;

public class EquipoMapper {
    public static EquipoDTO toDTO(Equipo equipo) {
        if (equipo == null) return null;

        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setTipo(equipo.getTipo().name());
        dto.setCategoria(equipo.getCategoria());
        dto.setPaisId(equipo.getPais() != null ? equipo.getPais().getId() : null);
        return dto;
    }

    public static Equipo toEntity(EquipoDTO dto, Pais pais) {
        if (dto == null) return null;

        return Equipo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .tipo(Equipo.TipoEquipo.valueOf(dto.getTipo()))
                .categoria(dto.getCategoria())
                .pais(pais)
                .build();
    }
}
