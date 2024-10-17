package com.grupo02.web.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Cine;

public interface CineRepository extends JpaRepository<Cine, Long> {
    @Query(
        value = "SELECT * FROM Cine c WHERE c.idAdmin = ?",
        nativeQuery = true
    )
    Optional<Cine> findByAdministradorId(Long administradorId);
}
