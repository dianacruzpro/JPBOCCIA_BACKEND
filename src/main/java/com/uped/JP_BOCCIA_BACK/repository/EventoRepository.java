package com.uped.JP_BOCCIA_BACK.repository;


import com.uped.JP_BOCCIA_BACK.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}

