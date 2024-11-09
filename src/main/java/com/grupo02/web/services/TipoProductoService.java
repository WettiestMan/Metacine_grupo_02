package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.TipoProductoDto;

public interface TipoProductoService {
    TipoProductoDto insertar(TipoProductoDto newBean);

    Optional<TipoProductoDto> obtenerPorId(Long id);

    List<TipoProductoDto> obtenerTodos();

    Optional<TipoProductoDto> actualizar(Long id, TipoProductoDto updBean);

    boolean eliminar(Long id);
}
