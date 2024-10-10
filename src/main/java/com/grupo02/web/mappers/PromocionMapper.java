package com.grupo02.web.mappers;

import com.grupo02.web.dto.PromocionDto;
import com.grupo02.web.models.Promocion;

public class PromocionMapper {
    public static PromocionDto toDto(Promocion bean){
        return new PromocionDto(
            bean.getId(),
            bean.getNombre(),
            bean.getDescripcion(),
            bean.getStock(),
            bean.getFechaInicio(),
            bean.getFechaFin(),
            CineMapper.toDto(bean.getCine())
        );
    }

    public static Promocion toModel(PromocionDto bean){
        var ret = new Promocion(
            bean.getId(),
            bean.getNombre(),
            bean.getDescripcion(),
            bean.getStock(),
            bean.getFechaInicio(),
            bean.getFechaFin()
        );

        ret.setCine(CineMapper.toModel(bean.getCine()));
        
        return ret;
    }
}
