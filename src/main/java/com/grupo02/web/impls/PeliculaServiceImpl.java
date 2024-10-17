package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.PeliculaDto;
import com.grupo02.web.mappers.ClasificacionMapper;
import com.grupo02.web.mappers.DirectorMapper;
import com.grupo02.web.mappers.GeneroMapper;
import com.grupo02.web.mappers.IdiomaMapper;
import com.grupo02.web.mappers.PeliculaMapper;
import com.grupo02.web.models.Pelicula;
import com.grupo02.web.repos.PeliculaRepository;
import com.grupo02.web.services.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    
    private final PeliculaRepository actor;

    public PeliculaServiceImpl(PeliculaRepository actor) {
        this.actor = actor;
    }

    @Override
    public PeliculaDto insertar(PeliculaDto newBean) {
        return PeliculaMapper.toDto(actor.save(PeliculaMapper.toModel(newBean)));
    }

    @Override
    public Optional<PeliculaDto> obtenerPorId(Long id) {
        return actor.findById(id).map(PeliculaMapper::toDto);
    }

    @Override
    public List<PeliculaDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(PeliculaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PeliculaDto> obtenerPorIdiomaId(Long id) {
        return actor.findByIdiomaId(id).stream()
                    .map(PeliculaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PeliculaDto> obtenerPorClasificacionId(Long id) {
        return actor.findByClasificacionId(id).stream()
                    .map(PeliculaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PeliculaDto> obtenerPorGeneroId(Long id) {
        return actor.findByGeneroId(id).stream()
                    .map(PeliculaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PeliculaDto> obtenerPorDirectorId(Long id) {
        return actor.findByDirectorId(id).stream()
                    .map(PeliculaMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<PeliculaDto> actualizar(Long id, PeliculaDto updBean) {
        Optional<Pelicula> actual = actor.findById(id);
        Pelicula saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setDescripcion(updBean.getDescripcion());
            actualRef.setClasificacion(ClasificacionMapper.toModel(updBean.getClasificacion()));
            actualRef.setDirector(DirectorMapper.toModel(updBean.getDirector()));
            actualRef.setDuracion(updBean.getDuracion());
            actualRef.setGenero(GeneroMapper.toModel(updBean.getGenero()));
            actualRef.setIdioma(IdiomaMapper.toModel(updBean.getIdioma()));

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? PeliculaMapper.toDto(saved) : null);
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
