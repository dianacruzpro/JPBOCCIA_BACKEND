package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
     @Override
    Partido getReferenceById(Long aLong);
}
