package com.grupo02.web.mappers;

import com.grupo02.web.dto.AdministradorDto;
import com.grupo02.web.dto.CineDto;
import com.grupo02.web.dto.DulceriaDto;
import com.grupo02.web.models.Administrador;
import com.grupo02.web.models.Cine;
import com.grupo02.web.models.Dulceria;

public class AdministradorMapper {
    public static AdministradorDto toDto(Administrador bean) {
        var ret = new AdministradorDto();
        ret.setId(bean.getId());
        ret.setNombre(bean.getNombre());
        ret.setCorreo(bean.getCorreo());

        var cineref = bean.getCine();
        var cine = new CineDto();
        cine.setId(cineref.getId());
        cine.setNombre(cineref.getNombre());
        cine.setDireccion(cineref.getDireccion());
        cine.setTelefono(cineref.getTelefono());
        cine.setAdmin(ret);

        var dulcref = bean.getCine().getDulceria();
        var dulc = new DulceriaDto();
        dulc.setId(dulcref.getId());
        dulc.setDireccion(dulcref.getDireccion());
        dulc.setCine(cine);

        cine.setDulceria(dulc);

        ret.setCine(cine);

        return ret;
    }

    public static Administrador toModel(AdministradorDto bean) {
        var ret = new Administrador();
        ret.setId(bean.getId());
        ret.setNombre(bean.getNombre());
        ret.setCorreo(bean.getCorreo());

        var cineref = bean.getCine();
        var cine = new Cine();
        cine.setId(cineref.getId());
        cine.setNombre(cineref.getNombre());
        cine.setDireccion(cineref.getDireccion());
        cine.setTelefono(cineref.getTelefono());
        cine.setAdmin(ret);

        var dulcref = bean.getCine().getDulceria();
        var dulc = new Dulceria();
        dulc.setId(dulcref.getId());
        dulc.setDireccion(dulcref.getDireccion());
        dulc.setCine(cine);

        cine.setDulceria(dulc);

        ret.setCine(cine);

        return ret;
    }
}
