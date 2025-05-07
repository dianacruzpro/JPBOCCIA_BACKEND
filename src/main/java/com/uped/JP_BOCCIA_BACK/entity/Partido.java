package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private Long jugador1_id;
    private Long jugador2_id;

    private Long equipo1_id;
    private Long equipo2_id;

    @ManyToOne
    @JoinColumn(name = "arbitro_principal_id")
    private Arbitro arbitroPrincipal;

    @Enumerated(EnumType.STRING)
    private EstadoPartido estado;

    private String resultadoFinal;

    public enum EstadoPartido {
        programado, en_juego, finalizado
    }

    /*   Getters and Setters    */
    // Generado con lombok
}
