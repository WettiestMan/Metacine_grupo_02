package com.grupo02.web.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(
        value = "SELECT * FROM Producto pd WHERE pd.idTipoProd = ?",
        nativeQuery = true
    )
    List<Producto> findByTipoProductoId(Long tipoProductoId);

    @Query(
        value = "SELECT * FROM Producto pd WHERE pd.idDuleria = ?",
        nativeQuery = true
    )
    List<Producto> findByDulceriaId(Long dulceriaId);
}
