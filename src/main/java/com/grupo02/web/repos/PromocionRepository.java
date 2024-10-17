package com.grupo02.web.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Long>{
    @Query(
        value = "SELECT * FROM Promocion pr WHERE pr.idCine = ?",
        nativeQuery = true
    )
    List<Promocion> findByCineId(Long cineId);

    @Query(
        value = "SELECT * FROM Promocion pr WHERE pr.stock = ?",
        nativeQuery = true
    )
    List<Promocion> findByStock(Integer stock);
}
