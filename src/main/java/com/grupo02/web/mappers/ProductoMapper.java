package com.grupo02.web.mappers;

import com.grupo02.web.dto.ProductoDto;
import com.grupo02.web.models.Producto;

public class ProductoMapper {
    public static ProductoDto toDto(Producto bean) {
        return new ProductoDto(
            bean.getId(),
            bean.getNombre(),
            bean.getPrecio(),
            bean.getDescripcion(),
            bean.getStock(),
            TipoProductoMapper.toDto(bean.getTipoProd()),
            DulceriaMapper.toDto(bean.getDulceria())
        );
    }

    public static Producto toModel(ProductoDto bean) {
        var ret = new Producto(
            bean.getId(),
            bean.getNombre(),
            bean.getPrecio(),
            bean.getDescripcion(),
            bean.getStock()
        );

        ret.setTipoProd(TipoProductoMapper.toModel(bean.getTipoProd()));
        ret.setDulceria(DulceriaMapper.toModel(bean.getDulceria()));

        return ret;
    }
}
