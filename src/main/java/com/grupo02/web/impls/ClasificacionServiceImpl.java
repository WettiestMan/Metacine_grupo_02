package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.ClasificacionDto;
import com.grupo02.web.mappers.ClasificacionMapper;
import com.grupo02.web.models.Clasificacion;
import com.grupo02.web.repos.ClasificacionRepository;
import com.grupo02.web.services.ClasificacionService;

@Service
public class ClasificacionServiceImpl implements ClasificacionService {
    
    private final ClasificacionRepository actor;

    public ClasificacionServiceImpl(ClasificacionRepository actor) {
        this.actor = actor;
    }

    @Override
    public ClasificacionDto insertar(ClasificacionDto newBean) {
        return ClasificacionMapper.toDto(actor.save(ClasificacionMapper.toModel(newBean)));
    }

    @Override
    public Optional<ClasificacionDto> obtenerPorId(Long id) {
        return actor.findById(id).map(ClasificacionMapper::toDto);
    }

    @Override
    public List<ClasificacionDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(x -> ClasificacionMapper.toDto(x))
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<ClasificacionDto> actualizar(Long id, ClasificacionDto updBean) {
        Optional<Clasificacion> actual = actor.findById(id);
        Clasificacion saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(updBean.getNombre());

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? ClasificacionMapper.toDto(saved) : null);
    }

    @Override
    public boolean eliminar(Long id) {
        var toDelete = actor.findById(id);
        if (toDelete.isPresent()) {
            actor.deleteById(id);
            return true;
        }

        return false;
    }
}
