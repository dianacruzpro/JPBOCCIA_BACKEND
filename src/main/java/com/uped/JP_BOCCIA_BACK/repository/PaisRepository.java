package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByNombre(String nombre);
    Optional<Pais> findById(Long aLong);
}
