package com.uped.JP_BOCCIA_BACK.repository;

import com.uped.JP_BOCCIA_BACK.entity.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {

}
