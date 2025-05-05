package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.PuntuacionDTO;
import com.uped.JP_BOCCIA_BACK.entity.Partido;
import com.uped.JP_BOCCIA_BACK.entity.Puntuacion;

public class PuntuacionMapper {

    public static PuntuacionDTO toDTO(Puntuacion puntuacion) {
        return PuntuacionDTO.builder()
                .id(puntuacion.getId())
                .partidoId(puntuacion.getPartido().getId())
                .numeroSet(puntuacion.getNumeroSet())
                .puntosEquipo1(puntuacion.getPuntosEquipo1())
                .puntosEquipo2(puntuacion.getPuntosEquipo2())
                .build();
    }

    public static Puntuacion toEntity(PuntuacionDTO dto, Partido partido) {
        return Puntuacion.builder()
                .id(dto.getId())
                .partido(partido)
                .numeroSet(dto.getNumeroSet())
                .puntosEquipo1(dto.getPuntosEquipo1())
                .puntosEquipo2(dto.getPuntosEquipo2())
                .build();
    }
}
