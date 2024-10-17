package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.DirectorDto;

public interface DirectorService {
    DirectorDto insertar(DirectorDto newBean);

    Optional<DirectorDto> obtenerPorId(Long id);

    List<DirectorDto> obtenerTodos();

    List<DirectorDto> obtenerPorNombre(String nombre);

    List<DirectorDto> obtenerPorApellido(String apellido);

    List<DirectorDto> obtenerPorNombreYApellido(String nombre, String apellido);

    Optional<DirectorDto> actualizar(Long id, DirectorDto updBean);

    boolean eliminar(Long id);
}
