package com.grupo02.web.services;

import java.util.Optional;
import java.util.List;

import com.grupo02.web.dto.ClasificacionDto;

public interface ClasificacionService {
    ClasificacionDto insertar(ClasificacionDto newBean);

    Optional<ClasificacionDto> obtenerPorId(Long id);

    List<ClasificacionDto> obtenerTodos();

    Optional<ClasificacionDto> actualizar(Long id, ClasificacionDto updBean);

    boolean eliminar(Long id);
}
