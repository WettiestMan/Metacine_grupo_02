package com.grupo02.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.TipoProducto;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long>{
    
}
