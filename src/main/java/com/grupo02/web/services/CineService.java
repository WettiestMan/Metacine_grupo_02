package com.grupo02.web.services;

import java.util.Optional;
import java.util.List;

import com.grupo02.web.dto.CineDto;

public interface CineService {
    CineDto insertar(CineDto newBean);

    Optional<CineDto> obtenerPorId(Long id);

    Optional<CineDto> obtenerPorAdministradorId(Long id);

    List<CineDto> obtenerTodos();

    Optional<CineDto> actualizar(Long id, CineDto updBean);

    boolean eliminar(Long id);
}
