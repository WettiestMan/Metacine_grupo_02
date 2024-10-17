package com.grupo02.web.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Long>{
    Optional<Director> findByNombre(String nombre);

    Optional<Director> findByApellido(String apellido);

    Optional<Director> findByNombreAndApellido(String nombre, String apellido);
}
