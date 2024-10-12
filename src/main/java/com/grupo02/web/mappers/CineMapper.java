package com.grupo02.web.mappers;

import com.grupo02.web.dto.AdministradorDto;
import com.grupo02.web.dto.CineDto;
import com.grupo02.web.dto.DulceriaDto;
import com.grupo02.web.models.Administrador;
import com.grupo02.web.models.Cine;
import com.grupo02.web.models.Dulceria;

public class CineMapper {
    public static CineDto toDto(Cine bean) {
        var ret = new CineDto();
        ret.setId(bean.getId());
        ret.setNombre(bean.getNombre());
        ret.setDireccion(bean.getDireccion());
        ret.setTelefono(bean.getTelefono());

        var adminref = bean.getAdmin();
        var admin = new AdministradorDto();
        admin.setId(adminref.getId());
        admin.setNombre(adminref.getNombre());
        admin.setCorreo(adminref.getCorreo());
        admin.setCine(ret);

        var dulcref = bean.getDulceria();
        var dulc = new DulceriaDto();
        dulc.setId(dulcref.getId());
        dulc.setDireccion(dulcref.getDireccion());
        dulc.setCine(ret);

        ret.setAdmin(admin);
        ret.setDulceria(dulc);
        return ret;
    }

    public static Cine toModel(CineDto bean) {
        var ret = new Cine();
        ret.setId(bean.getId());
        ret.setNombre(bean.getNombre());
        ret.setDireccion(bean.getDireccion());
        ret.setTelefono(bean.getTelefono());

        var adminref = bean.getAdmin();
        var admin = new Administrador();
        admin.setId(adminref.getId());
        admin.setNombre(adminref.getNombre());
        admin.setCorreo(adminref.getCorreo());
        admin.setCine(ret);

        var dulcref = bean.getDulceria();
        var dulc = new Dulceria();
        dulc.setId(dulcref.getId());
        dulc.setDireccion(dulcref.getDireccion());
        dulc.setCine(ret);

        ret.setAdmin(admin);
        ret.setDulceria(dulc);

        return ret;
    }
}
