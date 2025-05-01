package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    private String categoria;

    private LocalDate fecha;

    private String cancha;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    public enum TipoEvento {
        individual, pareja, equipo
    }


    /*   Getters and Setters    */
    //Generado con lombok
}
