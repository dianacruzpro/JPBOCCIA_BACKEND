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

    private Long jugador1Id;
    private Long jugador2Id;

    private Long equipo1Id;
    private Long equipo2Id;

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
