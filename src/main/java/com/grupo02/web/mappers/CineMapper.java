package com.grupo02.web.mappers;

import com.grupo02.web.dto.CineDto;
import com.grupo02.web.models.Cine;

public class CineMapper {
    public static CineDto toDto(Cine bean) {
        return new CineDto(
            bean.getId(),
            bean.getNombre(),
            bean.getDireccion(),
            bean.getTelefono(),
            AdministradorMapper.toDto(bean.getAdmin()),
            DulceriaMapper.toDto(bean.getDulceria())
        );
    }
}
