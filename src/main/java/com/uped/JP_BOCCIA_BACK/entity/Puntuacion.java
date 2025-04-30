package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;

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
    private Integer puntosEquipo1 = 0;
    private Integer puntosEquipo2 = 0;

    /*   Getters and Setters    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Integer getNumeroSet() {
        return numeroSet;
    }

    public void setNumeroSet(Integer numeroSet) {
        this.numeroSet = numeroSet;
    }

    public Integer getPuntosEquipo1() {
        return puntosEquipo1;
    }

    public void setPuntosEquipo1(Integer puntosEquipo1) {
        this.puntosEquipo1 = puntosEquipo1;
    }

    public Integer getPuntosEquipo2() {
        return puntosEquipo2;
    }

    public void setPuntosEquipo2(Integer puntosEquipo2) {
        this.puntosEquipo2 = puntosEquipo2;
    }
}

