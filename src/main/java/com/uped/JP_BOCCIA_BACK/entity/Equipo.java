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
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoEquipo tipo;

    private String categoria;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public enum TipoEquipo {
        pareja, equipo
    }

    /*   Getters and Setters    */
    //Generado con lombok
}