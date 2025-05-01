package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Long> {
    public Arbitro findByNombre(String nombre);
}
