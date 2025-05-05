package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "puntuacion")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    private Integer numeroSet;
    @Builder.Default
    private Integer puntosEquipo1 = 0;
    @Builder.Default
    private Integer puntosEquipo2 = 0;

    /*   Getters and Setters    */
    //Generado con lombok
}

