package com.grupo02.web.mappers;

import com.grupo02.web.dto.TipoProductoDto;
import com.grupo02.web.models.TipoProducto;

public class TipoProductoMapper {

    public static TipoProductoDto toDto(TipoProducto bean) {
        return new TipoProductoDto(
            bean.getId(),
            bean.getNombre()
        );
    }

    public static TipoProducto toModel(TipoProductoDto bean) {
        return new TipoProducto(
            bean.getId(),
            bean.getNombre()
        );
    }
}
