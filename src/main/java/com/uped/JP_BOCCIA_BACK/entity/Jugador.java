package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String genero;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public enum Categoria {
        BC1, BC2, BC3, BC4
    }

    /*   Getters and Setters con lombok */

}
