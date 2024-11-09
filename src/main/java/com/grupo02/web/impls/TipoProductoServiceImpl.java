package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.TipoProductoDto;
import com.grupo02.web.mappers.TipoProductoMapper;
import com.grupo02.web.models.TipoProducto;
import com.grupo02.web.repos.TipoProductoRepository;
import com.grupo02.web.services.TipoProductoService;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository actor;

    public TipoProductoServiceImpl(TipoProductoRepository actor) {
        this.actor = actor;
    }
    
    @Override
    public TipoProductoDto insertar(TipoProductoDto newBean) {
        return TipoProductoMapper.toDto(actor.save(TipoProductoMapper.toModel(newBean)));
    }

    @Override
    public Optional<TipoProductoDto> obtenerPorId(Long id) {
        return actor.findById(id).map(TipoProductoMapper::toDto);
    }

    @Override
    public List<TipoProductoDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(TipoProductoMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoProductoDto> actualizar(Long id, TipoProductoDto newBean) {
        Optional<TipoProducto> actual = actor.findById(id);
        TipoProducto saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(newBean.getNombre());

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? TipoProductoMapper.toDto(saved) : null);
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
