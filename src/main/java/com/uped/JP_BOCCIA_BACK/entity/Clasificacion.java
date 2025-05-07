package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    @Enumerated(EnumType.STRING)
    private TipoClasificacion tipo;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    private Integer posicion;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public enum TipoClasificacion {
        jugador, equipo
    }



    /*   Getters and Setters    */
    //Generados con lombok
}
