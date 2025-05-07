package com.uped.JP_BOCCIA_BACK.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartidoDTO {
    private Long id;

    private Long eventoId;

    private Long jugador1_id;
    private Long jugador2_id;

    private Long equipo1_id;
    private Long equipo2_id;

    private Long arbitro_id;

    private String estado; // Como texto (programado, en_juego, finalizado)

    private String resultadoFinal;
}
