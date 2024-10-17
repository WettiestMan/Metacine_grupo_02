package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.CineDto;
import com.grupo02.web.mappers.AdministradorMapper;
import com.grupo02.web.mappers.CineMapper;
import com.grupo02.web.mappers.DulceriaMapper;
import com.grupo02.web.models.Cine;
import com.grupo02.web.repos.CineRepository;
import com.grupo02.web.services.CineService;

@Service
public class CineServiceImpl implements CineService{

    private final CineRepository actor;

    public CineServiceImpl(CineRepository cr) {
        actor = cr;
    }

    @Override
    public CineDto insertar(CineDto newBean) {
        return CineMapper.toDto(actor.save(CineMapper.toModel(newBean)));
    }

    @Override
    public Optional<CineDto> obtenerPorId(Long id) {
        return actor.findById(id).map(CineMapper::toDto);
    }

    @Override
    public Optional<CineDto> obtenerPorAdministradorId(Long id) {
        return actor.findByAdministradorId(id).map(CineMapper::toDto);
    }

    @Override
    public List<CineDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(CineMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<CineDto> actualizar(Long id, CineDto updBean) {
        Optional<Cine> actual = actor.findById(id);
        Cine saved = null;

        if (actual.isPresent()) {
            Cine ref = actual.get();
            ref.setNombre(updBean.getNombre());
            ref.setTelefono(updBean.getTelefono());
            ref.setAdmin(AdministradorMapper.toModel(updBean.getAdmin()));
            ref.setDireccion(updBean.getDireccion());
            ref.setDulceria(DulceriaMapper.toModel(updBean.getDulceria()));

            saved = actor.save(ref);
        }

        return Optional.ofNullable((saved == null) ? CineMapper.toDto(saved) : null);
    }

    @Override
    public boolean eliminar(Long id) {
        var toDelete = actor.findById(id);
        if(toDelete.isPresent()) {
            actor.deleteById(id);
            return true;
        }

        return false;
    }
}
