package com.grupo02.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    
}
