package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.models.Director;
import com.grupo02.web.dto.DirectorDto;
import com.grupo02.web.mappers.DirectorMapper;
import com.grupo02.web.repos.DirectorRepository;
import com.grupo02.web.services.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {
    
    private DirectorRepository actor;

    public DirectorServiceImpl(DirectorRepository ds) {
        actor = ds;
    }

    @Override
    public DirectorDto insertar(DirectorDto newBean) {
        return DirectorMapper.toDto(actor.save(DirectorMapper.toModel(newBean)));
    }

    @Override
    public Optional<DirectorDto> obtenerPorId(Long id) {
        return actor.findById(id).map(DirectorMapper::toDto);
    }

    @Override
    public List<DirectorDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(DirectorMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<DirectorDto> obtenerPorNombre(String nombre) {
        return actor.findByNombre(nombre).stream()
                    .map(DirectorMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<DirectorDto> obtenerPorApellido(String apellido) {
        return actor.findByApellido(apellido).stream()
                    .map(DirectorMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<DirectorDto> obtenerPorNombreYApellido(String nombre, String apellido) {
        return actor.findByNombreAndApellido(nombre, apellido).stream()
                    .map(DirectorMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<DirectorDto> actualizar(Long id, DirectorDto newBean) {
        Optional<Director> actual = actor.findById(id);
        Director saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(newBean.getNombre());
            actualRef.setApellido(newBean.getApellido());

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? DirectorMapper.toDto(saved) : null);
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
