package com.grupo02.web.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo02.web.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    @Query(
        value = "SELECT * FROM Pelicula p WHERE p.idGenero = ?",
        nativeQuery = true
    )
    List<Pelicula> findByGeneroId(Long generoId);

    @Query(
        value = "SELECT * FROM Pelicula p WHERE p.idIdioma = ?",
        nativeQuery = true
    )
    List<Pelicula> findByIdiomaId(Long idiomaId);

    @Query(
        value = "SELECT * FROM Pelicula p WHERE p.idDirector = ?",
        nativeQuery = true
    )
    List<Pelicula> findByDirectorId(Long directorId);

    @Query(
        value = "SELECT * FROM Pelicula p WHERE p.idClasificacion = ?",
        nativeQuery = true
    )
    List<Pelicula> findByClasificacionId(Long clasificacionId);
}
