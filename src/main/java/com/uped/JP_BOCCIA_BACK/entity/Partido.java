package com.uped.JP_BOCCIA_BACK.entity;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Long getJugador1Id() {
        return jugador1Id;
    }

    public void setJugador1Id(Long jugador1Id) {
        this.jugador1Id = jugador1Id;
    }

    public Long getJugador2Id() {
        return jugador2Id;
    }

    public void setJugador2Id(Long jugador2Id) {
        this.jugador2Id = jugador2Id;
    }

    public Long getEquipo1Id() {
        return equipo1Id;
    }

    public void setEquipo1Id(Long equipo1Id) {
        this.equipo1Id = equipo1Id;
    }

    public Long getEquipo2Id() {
        return equipo2Id;
    }

    public void setEquipo2Id(Long equipo2Id) {
        this.equipo2Id = equipo2Id;
    }

    public Arbitro getArbitroPrincipal() {
        return arbitroPrincipal;
    }

    public void setArbitroPrincipal(Arbitro arbitroPrincipal) {
        this.arbitroPrincipal = arbitroPrincipal;
    }

    public EstadoPartido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }
}
