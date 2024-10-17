package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.DulceriaDto;

public interface DulceriaService {
    DulceriaDto insertar(DulceriaDto newBean);

    Optional<DulceriaDto> obtenerPorId(Long id);

    Optional<DulceriaDto> obtenerPorCineId(Long id);

    List<DulceriaDto> obtenerTodos();

    Optional<DulceriaDto> actualizar(Long id, DulceriaDto updBean);

    boolean eliminar(Long id);
}
