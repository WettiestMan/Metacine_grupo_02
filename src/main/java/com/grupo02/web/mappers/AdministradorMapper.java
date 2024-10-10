package com.grupo02.web.mappers;

import com.grupo02.web.dto.AdministradorDto;
import com.grupo02.web.models.Administrador;

public class AdministradorMapper {
    public static AdministradorDto toDto(Administrador bean) {
        return new AdministradorDto(
            bean.getId(),
            bean.getNombre(),
            bean.getCorreo(),
            CineMapper.toDto(bean.getCine())
        );
    }

    public static Administrador toModel(AdministradorDto bean) {
        return new Administrador(
            bean.getId(),
            bean.getNombre(),
            bean.getCorreo(),
            CineMapper.toModel(bean.getCine())
        );
    }
}
