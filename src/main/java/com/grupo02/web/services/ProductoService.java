package com.grupo02.web.services;

import java.util.List;
import java.util.Optional;

import com.grupo02.web.dto.ProductoDto;

public interface ProductoService {
    ProductoDto insertar(ProductoDto newBean);

    Optional<ProductoDto> obtenerPorId(Long id);

    List<ProductoDto> obtenerPorTipoProductoId(Long id);

    List<ProductoDto> obtenerPorDulceriaId(Long id);

    List<ProductoDto> obtenerTodos();

    Optional<ProductoDto> actualizar(Long id, ProductoDto updBean);

    boolean eliminar(Long id);
}
