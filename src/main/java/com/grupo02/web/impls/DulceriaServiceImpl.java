package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.DulceriaDto;
import com.grupo02.web.mappers.DulceriaMapper;
import com.grupo02.web.mappers.CineMapper;
import com.grupo02.web.models.Dulceria;
import com.grupo02.web.repos.DulceriaRepository;
import com.grupo02.web.services.DulceriaService;

@Service
public class DulceriaServiceImpl implements DulceriaService{
    
    private final DulceriaRepository actor;

    public DulceriaServiceImpl(DulceriaRepository actor) {
        this.actor = actor;
    }

    @Override
    public DulceriaDto insertar(DulceriaDto newBean) {
        Dulceria adm = DulceriaMapper.toModel(newBean);
        Dulceria saved = actor.save(adm);
        return DulceriaMapper.toDto(saved);
    }

    @Override
    public List<DulceriaDto> obtenerTodos() {
        List<Dulceria> ret = actor.findAll();
        return ret.stream().map(DulceriaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<DulceriaDto> obtenerPorId(Long id) {
        Optional<Dulceria> ret = actor.findById(id);
        return ret.map(DulceriaMapper::toDto);
    }

    @Override
    public Optional<DulceriaDto> obtenerPorCineId(Long id) {
        return actor.findByCineId(id).map(DulceriaMapper::toDto);
    }

    @Override
    public Optional<DulceriaDto> actualizar(Long id, DulceriaDto updBean) {
        Optional<Dulceria> actual = actor.findById(id);
        Dulceria saved = null;
        if (actual.isPresent()) {
            Dulceria ref = actual.get();
            ref.setDireccion(updBean.getDireccion());
            ref.setCine(CineMapper.toModel(updBean.getCine()));

            saved = actor.save(ref);
        }
        return Optional.ofNullable((saved == null) ? DulceriaMapper.toDto(saved) : null);
    }

    @Override
    public boolean eliminar(Long id) {
        Optional<Dulceria> toRemove = actor.findById(id);
        if (toRemove.isPresent()) {
            actor.deleteById(id);
            return true;
        }

        return false;
    }
}
