package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.IdiomaDto;
import com.grupo02.web.mappers.IdiomaMapper;
import com.grupo02.web.models.Idioma;
import com.grupo02.web.repos.IdiomaRepository;
import com.grupo02.web.services.IdiomaService;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    private final IdiomaRepository actor;

    public IdiomaServiceImpl(IdiomaRepository actor) {
        this.actor = actor;
    }
    
    @Override
    public IdiomaDto insertar(IdiomaDto newBean) {
        return IdiomaMapper.toDto(actor.save(IdiomaMapper.toModel(newBean)));
    }

    @Override
    public Optional<IdiomaDto> obtenerPorId(Long id) {
        return actor.findById(id).map(IdiomaMapper::toDto);
    }

    @Override
    public List<IdiomaDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(IdiomaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<IdiomaDto> actualizar(Long id, IdiomaDto newBean) {
        Optional<Idioma> actual = actor.findById(id);
        Idioma saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(newBean.getNombre());

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? IdiomaMapper.toDto(saved) : null);
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
