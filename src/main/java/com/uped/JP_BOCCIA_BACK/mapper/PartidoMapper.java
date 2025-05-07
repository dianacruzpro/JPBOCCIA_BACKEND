package com.uped.JP_BOCCIA_BACK.mapper;

import com.uped.JP_BOCCIA_BACK.dto.PartidoDTO;
import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import com.uped.JP_BOCCIA_BACK.entity.Evento;
import com.uped.JP_BOCCIA_BACK.entity.Partido;

public class PartidoMapper {

    public static PartidoDTO toDTO(Partido partido) {
        if (partido == null) {
            return null;
        }

        return PartidoDTO.builder()
                .id(partido.getId())
                .eventoId(partido.getEvento() != null ? partido.getEvento().getId() : null)
                .jugador1_id(partido.getJugador1_id())
                .jugador2_id(partido.getJugador2_id())
                .equipo1_id(partido.getEquipo1_id())
                .equipo2_id(partido.getEquipo2_id())
                .arbitro_id(partido.getArbitroPrincipal() != null ? partido.getArbitroPrincipal().getId() : null)
                .estado(partido.getEstado() != null ? partido.getEstado().name() : null)
                .resultadoFinal(partido.getResultadoFinal())
                .build();
    }

    public static Partido toEntity(PartidoDTO dto, Evento evento, Arbitro arbitro) {
        if (dto == null) {
            return null;
        }

        return Partido.builder()
                .id(dto.getId())
                .evento(evento)
                .jugador1_id(dto.getJugador1_id())
                .jugador2_id(dto.getJugador2_id())
                .equipo1_id(dto.getEquipo1_id())
                .equipo2_id(dto.getEquipo2_id())
                .arbitroPrincipal(arbitro)
                .estado(dto.getEstado() != null ? Partido.EstadoPartido.valueOf(dto.getEstado()) : null)
                .resultadoFinal(dto.getResultadoFinal())
                .build();
    }
}
