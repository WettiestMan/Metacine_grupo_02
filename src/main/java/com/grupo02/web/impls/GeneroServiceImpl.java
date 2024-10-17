package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.GeneroDto;
import com.grupo02.web.mappers.GeneroMapper;
import com.grupo02.web.models.Genero;
import com.grupo02.web.services.GeneroService;
import com.grupo02.web.repos.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService {
    
    private final GeneroRepository actor;

    public GeneroServiceImpl(GeneroRepository actor) {
        this.actor = actor;
    }
    
    @Override
    public GeneroDto insertar(GeneroDto newBean) {
        return GeneroMapper.toDto(actor.save(GeneroMapper.toModel(newBean)));
    }

    @Override
    public Optional<GeneroDto> obtenerPorId(Long id) {
        return actor.findById(id).map(GeneroMapper::toDto);
    }

    @Override
    public List<GeneroDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(GeneroMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<GeneroDto> actualizar(Long id, GeneroDto newBean) {
        Optional<Genero> actual = actor.findById(id);
        Genero saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(newBean.getNombre());

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? GeneroMapper.toDto(saved) : null);
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
