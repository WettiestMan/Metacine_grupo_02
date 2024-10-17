package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.IdiomaDto;

public interface IdiomaService {
    Optional<IdiomaDto> insertar(IdiomaDto newBean);

    Optional<IdiomaDto> obtenerPorId(Long id);

    List<IdiomaDto> obtenerTodos();

    Optional<IdiomaDto> actualizar(Long id, IdiomaDto updBean);

    boolean eliminar(Long id);
}
