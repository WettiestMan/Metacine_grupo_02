package com.grupo02.web.mappers;

import com.grupo02.web.dto.AdministradorDto;
import com.grupo02.web.dto.CineDto;
import com.grupo02.web.dto.DulceriaDto;
import com.grupo02.web.models.Administrador;
import com.grupo02.web.models.Cine;
import com.grupo02.web.models.Dulceria;

public class DulceriaMapper {
    public static DulceriaDto toDto(Dulceria bean) {
        var ret = new DulceriaDto();
        ret.setId(bean.getId());
        ret.setDireccion(bean.getDireccion());

        var cineref = bean.getCine();
        var cine = new CineDto();
        cine.setId(cineref.getId());
        cine.setNombre(cineref.getNombre());
        cine.setTelefono(cineref.getTelefono());
        cine.setDireccion(cineref.getDireccion());
        
        var adminref = bean.getCine().getAdmin();
        var admin = new AdministradorDto();
        admin.setId(adminref.getId());
        admin.setNombre(adminref.getNombre());
        admin.setCorreo(adminref.getCorreo());
        admin.setCine(cine);

        cine.setAdmin(admin);
        cine.setDulceria(ret);

        ret.setCine(cine);

        return ret;
    }

    public static Dulceria toModel(DulceriaDto bean) {
        var ret = new Dulceria();
        ret.setId(bean.getId());
        ret.setDireccion(bean.getDireccion());

        var cineref = bean.getCine();
        var cine = new Cine();
        cine.setId(cineref.getId());
        cine.setNombre(cineref.getNombre());
        cine.setTelefono(cineref.getTelefono());
        cine.setDireccion(cineref.getDireccion());
        
        var adminref = bean.getCine().getAdmin();
        var admin = new Administrador();
        admin.setId(adminref.getId());
        admin.setNombre(adminref.getNombre());
        admin.setCorreo(adminref.getCorreo());
        admin.setCine(cine);

        cine.setAdmin(admin);
        cine.setDulceria(ret);

        ret.setCine(cine);

        return ret;
    }
}
