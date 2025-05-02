package com.uped.JP_BOCCIA_BACK.repository;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    Jugador findByNombre(String nombre);
}
