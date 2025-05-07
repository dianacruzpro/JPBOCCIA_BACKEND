package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.ClasificacionDTO;
import com.uped.JP_BOCCIA_BACK.entity.Clasificacion;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClasificacionMapper {

    public static ClasificacionDTO toDTO(Clasificacion clasificacion) {
        ClasificacionDTO dto = new ClasificacionDTO();
        dto.setId(clasificacion.getId());
        dto.setTorneoID(clasificacion.getTorneo().getId());
        dto.setTipo(clasificacion.getTipo().name());

        if (clasificacion.getJugador() != null) {
            dto.setJugadorID(clasificacion.getJugador().getId());
        }

        if (clasificacion.getEquipo() != null) {
            dto.setEquipoID(clasificacion.getEquipo().getId());
        }

        dto.setPosicion(clasificacion.getPosicion());
        dto.setFechaRegistro(LocalDate.from(clasificacion.getFechaRegistro()));
        return dto;
    }


    public static Clasificacion toEntity(ClasificacionDTO dto, Torneo torneo, Jugador jugador, Equipo equipo) {
        Clasificacion.TipoClasificacion tipo;
        try {
            tipo = Clasificacion.TipoClasificacion.valueOf(dto.getTipo());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de clasificación inválido: " + dto.getTipo());
        }

        return Clasificacion.builder()
                .id(dto.getId())
                .torneo(torneo)
                .tipo(tipo)
                .jugador(jugador)
                .equipo(equipo)
                .posicion(Integer.valueOf(dto.getPosicion()))
                .fechaRegistro(dto.getFechaRegistro().atStartOfDay())
                .build();
    }

}
