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
                .jugador1Id(partido.getJugador1Id())
                .jugador2Id(partido.getJugador2Id())
                .equipo1Id(partido.getEquipo1Id())
                .equipo2Id(partido.getEquipo2Id())
                .arbitroId(partido.getArbitroPrincipal() != null ? partido.getArbitroPrincipal().getId() : null)
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
                .jugador1Id(dto.getJugador1Id())
                .jugador2Id(dto.getJugador2Id())
                .equipo1Id(dto.getEquipo1Id())
                .equipo2Id(dto.getEquipo2Id())
                .arbitroPrincipal(arbitro)
                .estado(dto.getEstado() != null ? Partido.EstadoPartido.valueOf(dto.getEstado()) : null)
                .resultadoFinal(dto.getResultadoFinal())
                .build();
    }
}
