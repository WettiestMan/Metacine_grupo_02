package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.AdministradorDto;
import com.grupo02.web.mappers.AdministradorMapper;
import com.grupo02.web.mappers.CineMapper;
import com.grupo02.web.models.Administrador;
import com.grupo02.web.repos.AdministradorRepository;
import com.grupo02.web.services.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService{
    
    private final AdministradorRepository actor;

    public AdministradorServiceImpl(AdministradorRepository actor) {
        this.actor = actor;
    }

    @Override
    public AdministradorDto insertar(AdministradorDto newBean) {
        Administrador adm = AdministradorMapper.toModel(newBean);
        Administrador saved = actor.save(adm);
        return AdministradorMapper.toDto(saved);
    }

    @Override
    public List<AdministradorDto> obtenerTodos() {
        List<Administrador> ret = actor.findAll();
        return ret.stream().map(AdministradorMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AdministradorDto> obtenerPorId(Long id) {
        Optional<Administrador> ret = actor.findById(id);
        return ret.map(AdministradorMapper::toDto);
    }

    @Override
    public Optional<AdministradorDto> obtenerPorCineId(Long id) {
        return actor.findByCineId(id).map(AdministradorMapper::toDto);
    }

    @Override
    public Optional<AdministradorDto> actualizar(Long id, AdministradorDto updBean) {
        Optional<Administrador> actual = actor.findById(id);
        Administrador saved = null;
        if (actual.isPresent()) {
            Administrador ref = actual.get();
            ref.setNombre(updBean.getNombre());
            ref.setCorreo(updBean.getCorreo());
            ref.setCine(CineMapper.toModel(updBean.getCine()));

            saved = actor.save(ref);
        }
        return Optional.ofNullable((saved == null) ? AdministradorMapper.toDto(saved) : null);
    }

    @Override
    public boolean eliminar(Long id) {
        Optional<Administrador> toRemove = actor.findById(id);
        if (toRemove.isPresent()) {
            actor.deleteById(id);
            return true;
        }

        return false;
    }
}
