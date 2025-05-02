package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.EquipoJugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoJugadorRepository extends JpaRepository<EquipoJugador, Long> {
    EquipoJugador findByEquipoIdAndJugadorId(Long equipoId, Long jugadorId);
}
