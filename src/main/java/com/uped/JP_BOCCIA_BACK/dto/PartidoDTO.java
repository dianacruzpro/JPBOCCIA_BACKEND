package com.uped.JP_BOCCIA_BACK.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartidoDTO {
    private Long id;

    private Long eventoId;

    private Long jugador1Id;
    private Long jugador2Id;

    private Long equipo1Id;
    private Long equipo2Id;

    private Long arbitroId;

    private String estado; // Como texto (programado, en_juego, finalizado)

    private String resultadoFinal;
}
