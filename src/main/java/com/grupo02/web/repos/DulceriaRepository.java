package com.grupo02.web.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Dulceria;

public interface DulceriaRepository extends JpaRepository<Dulceria, Long>{
    @Query(
        value = "SELECT * FROM Dulceria d WHERE d.idCine = ?",
        nativeQuery = true
    )
    Optional<Dulceria> findByCineId(Long cineId);
}
