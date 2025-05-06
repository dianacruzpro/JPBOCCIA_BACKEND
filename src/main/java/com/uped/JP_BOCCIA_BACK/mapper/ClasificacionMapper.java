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
        dto.setTipo(String.valueOf(clasificacion.getTipo()));
        dto.setJugadorID(clasificacion.getJugador().getId());
        dto.setEquipoID(clasificacion.getEquipo().getId());
        dto.setPosicion(String.valueOf(clasificacion.getPosicion()));
        dto.setFechaRegistro(LocalDate.from(clasificacion.getFechaRegistro()));
        return dto;
    }

    public static Clasificacion toEntity(ClasificacionDTO dto, Torneo torneo, Jugador jugador, Equipo equipo) {
        return Clasificacion.builder()
                .id(dto.getId()) // Use getId() instead of id
                .torneo(torneo)
                .tipo(Clasificacion.TipoClasificacion.valueOf(dto.getTipo()))
                .jugador(jugador)
                .equipo(equipo)
                .posicion(Integer.valueOf(dto.getPosicion()))
                .fechaRegistro(dto.getFechaRegistro().atStartOfDay())
                .build();
    }
}
