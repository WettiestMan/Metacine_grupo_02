package com.grupo02.web.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
    @Query(
        value = "SELECT * FROM Administrador a WHERE a.idCine = ?",
        nativeQuery = true
    )
    Optional<Administrador> findByCineId(Long cineId);
}
