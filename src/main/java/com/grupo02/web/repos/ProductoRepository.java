package com.grupo02.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
