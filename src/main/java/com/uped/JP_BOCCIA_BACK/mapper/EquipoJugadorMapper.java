package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.EquipoJugadorDTO;
import com.uped.JP_BOCCIA_BACK.entity.EquipoJugador;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;

public class EquipoJugadorMapper {

    public static EquipoJugadorDTO toDTO(EquipoJugador entity) {
        EquipoJugadorDTO dto = new EquipoJugadorDTO();
        dto.setId(entity.getId());
        dto.setEquipoId(entity.getEquipo().getId());
        dto.setJugadorId(entity.getJugador().getId());
        return dto;
    }

    public static EquipoJugador toEntity(EquipoJugadorDTO dto, Equipo equipo, Jugador jugador) {
        return EquipoJugador.builder()
                .id(dto.getId())
                .equipo(equipo)
                .jugador(jugador)
                .build();
    }
}