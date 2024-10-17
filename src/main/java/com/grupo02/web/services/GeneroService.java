package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.GeneroDto;

public interface GeneroService {
    GeneroDto insertar(GeneroDto newBean);

    Optional<GeneroDto> obtenerPorId(Long id);

    List<GeneroDto> obtenerTodos();

    Optional<GeneroDto> actualizar(Long id, GeneroDto updBean);

    boolean eliminar(Long id);
}
